Blog Application
--- Blog App --------------------------------------------------------------------------------------
Playlist:  Backend course using spring boot

https://youtube.com/playlist?list=PL0zysOflRCen-GihOcm1hZfYAlwr63K_M&si=SDp9Gc8NKoBDV9Su
Project Info:
-	1st you should create User.Class and Category.Class
-	Then create Post.Class
1.Install LOMBOK
-	To Use Lombok, need to download jar 1st.
-	In chrome write: Lombok jar download.
-	Pest in STS folder
-	Open CMD from STS.exe location
-	And write: java -jar lombok.jar
-	One installation window will be open and it will show path for eclipse only
-	You have to add STS path, (select STS.exe)
-	Install/quit.
-	Update project – maven
Lombok jar :    
                       
2.Model Mapper:
We can use Model Mapper to convert one object to another (convert one class to another)
<!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
<dependency>
<groupId>org.modelmapper</groupId>
<artifactId>modelmapper</artifactId>
<version>3.1.1</version>
</dependency>
-	Declare in main class
                            @Bean
	    public ModelMapper modelMapper () {
		return new ModelMapper ();
-		}
-	Autowired in Service class.
         @Autowired
-		private ModelMapper modelMapper;
-	
-	It will create object.
-	
-	   --------- converting user to dto
//	    private UserDto userToDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
//		return userDto;
//	     }
	
	    private UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user,    
         UserDto.class);
		return userDto;
-		}

3.Validation using Bean Validator:
We can validate field using Annotations.
-	Search for “hibernate validator spring boot maven”.
-	.
-	1. Copy dependency 
-	      <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
-	      <dependency>
-	      <groupId>org.springframework.boot</groupId>
-	      <artifactId>spring-boot-starter-validation</artifactId>
-	      <version>3.1.2</version>
-	      </dependency>
-	.
-	2. Annotate the Entity Class field
-	    @NotEmpty/ @NotBlank
-	    @Size(min =4, message=”..something..”)……. If you can’t give message, it will take default message.
-	    String name;
-	
-	    @Email(message=””)
-	    String email;
-	
-	    @Pattern(regexp=””)
-	    @Size(min=4, max=10)
-	    String password;
-	.
-	3. Use @Valid in controller
-	     For create user 
-	     And update user
       //create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCat(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategory = this.categoryService.createCat(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
-		}
-	.
-	4. It will throw exception and need to handle.
-	    So, in GlobalExceptionHandler we created method.

4.Created Entity User, Category, Post
5.Repository-> Services-> Controller
6.ManyToOne Mapping In Post.Class
-	For Post table Category and User field column will be added.
-	In Post database new column will be added(category, user)
-	Post.Class ->
     @ManyToOne
	private Category category;
	
	@ManyToOne
private User user;

-	Category.Class ->
     @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,   
       fetch = FetchType.LAZY)
private List<Post> posts = new ArrayList<>();

-	User.Class ->
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
                   private List<Post> posts = new ArrayList<>();

7.custom finder method
custom finder method created in PostRepository:
-	List<Post> findByUser(User user);
-	List<Post> findByCategory(Category category);

custom finder method created in PostServiceImpl:
-	       //get post by category
	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "Category Id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		// you should take same name as lambda
		// ((post)->this.modelMapper.map(post, PostDto.class))
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}


-	       //get post by user
	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		// you should take same name as lambda
		// ((post)->this.modelMapper.map(post, PostDto.class))
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList()); 
		return postDtos;
	}

custom finder method created in PostController:
-	       //get by category
	       @GetMapping("/category/{categoryId}/posts")
	       public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);	
	}	
-	       // get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		List<PostDto> posts = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);	
	}
8.Pagination:
-	Import From: import org.springframework.data.domain.Pageable;
-	Page size and page number. – pageNumber start from 0
-	Sorting by any one field.
-	ONLY FOR GET ALL POST
-	URL:  http://localhost:8080/api/posts?pageNumber=0&pageSize=5
-	.
-	In PostServiceImpl: instead of getAllPost implemented new method.
-	Ex- 
-	OLD-
-	       // get all post (PostServiceImpl)
		@Override
		public List<PostDto> getAllPost() {
			List<Post> allPosts = this.postRepo.findAll(); 
			// converting Post.Class to PostDto.Class
			List<PostDto> postDtos = allPosts.stream().map((Post)->this.modelMapper.map(Post,  
                      PostDto.class)).collect(Collectors.toList());
			return postDtos;
		}
-	
-	After pagination –
-	// Pagination for all post
// get all post - Integer pageNumber, Integer pageSize - added for Pagination.
		@Override
		public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize) {
			
			//Imported from: import org.springframework.data.domain.Pageable;
			Pageable p = PageRequest.of(pageNumber, pageSize);
			Page<Post> pagePost = this.postRepo.findAll(p);
			
			List<Post> allPosts = pagePost.getContent();
			// converting Post.Class to PostDto.Class
			List<PostDto> postDtos = allPosts.stream().map((Post)->this.modelMapper.map(Post, PostDto.class)).collect(Collectors.toList());
			return postDtos;
}
-	
-	In PostController:
-	
-	// get all post 
	// Integer pageNumber, Integer pageSize - added for Pagination.
	// GetMapping is OK(/posts), but in postman you have to mention like->
	// http://localhost:8080/api/posts?pageNumber=0&pageSize=2 
       ^ change pageNumber & pageSize accordingly.
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(@RequestParam(value="pageNumber",defaultValue="1",required=false) Integer pageNumber,@RequestParam(value="pageSize",defaultValue="3",required=false) Integer pageSize){
		List<PostDto> allPost = this.postService.getAllPost(pageNumber, pageSize);
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);	
	}
9.Pagination Response
Created PostResponse Class – to generate Response (PostMan)
PostService - changed return type "List<PostDto>" to "PostResponse" to get Pagination response.
PoseServiceImpl – changed return "List<PostDto>" to "PostResponse" to get Pagination response.
-	public PostResponse getAllPost(Integer pageNumber, Integer pageSize) {
-				
-				//Imported from: import org.springframework.data.domain.Pageable;
-				Pageable p = PageRequest.of(pageNumber, pageSize);
-				Page<Post> pagePost = this.postRepo.findAll(p);
-				
-				List<Post> allPosts = pagePost.getContent();
-				// converting Post.Class to PostDto.Class
-				List<PostDto> postDtos = allPosts.stream().map((Post)->this.modelMapper.map(Post, PostDto.class)).collect(Collectors.toList());
-				
-				// comes from PostResponse.Class
-				PostResponse postResponse = new PostResponse();
-				postResponse.setContent(postDtos);
-				postResponse.setPageNumber(pagePost.getNumber());
-				postResponse.setPageSize(pagePost.getSize());
-				postResponse.setTotalElements(pagePost.getTotalElements());
-				postResponse.setTotalPages(pagePost.getTotalPages());
-				postResponse.setLastPage(pagePost.isLast());
-				
-				return postResponse;
-			}
PostController – 
-	               // get all post 
-		// Integer pageNumber, Integer pageSize - added for Pagination.
-		// GetMapping is OK(/posts), but in postman you must mention like->
-		// http://localhost:8080/api/posts?pageNumber=0&pageSize=2
-		// change pageNumber & pageSize accordingly.
-		@GetMapping("/posts")
-		public ResponseEntity<PostResponse> getAllPost(@RequestParam(value="pageNumber",defaultValue="0",required=false) Integer pageNumber,@RequestParam(value="pageSize",defaultValue="3",required=false) Integer pageSize){
-			PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize);
-			return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);	
-		}
10.Sorting in getAllPost- required = false – if we not mention in URL then it will give default data
URL : http://localhost:8080/api/posts?pageNumber=0&pageSize=5&sortBy=postId&sortDir=desc
PostController- added argument – sortBy and sortDir.
-	@GetMapping("/posts")
-		public ResponseEntity<PostResponse> getAllPost(
-	@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
-	@RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize,
-	@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
-	@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) 
-	{	
-	PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
-	return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
-	}
PostService- added argument – sortBy and sortDir.
-	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
PostServiceImpl- added argument – sortBy and sortDir.
-	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
-				
-	//			Sort sort = null;
-	//			if(sortDir.equalsIgnoreCase("asc")) {
-	//				sort=Sort.by(sortBy).ascending();
-	//			}else {
-	//				sort=Sort.by(sortBy).descending();
-	//			}
-				// for ascending/ descending order
-				// ternary operator used.
-				Sort sort = (sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
-				
-				//Imported from: import org.springframework.data.domain.Pageable;
-				Pageable p = PageRequest.of(pageNumber, pageSize, sort);
-				Page<Post> pagePost = this.postRepo.findAll(p);
-				
-				List<Post> allPosts = pagePost.getContent();
-				// converting Post.Class to PostDto.Class
-				List<PostDto> postDtos = allPosts.stream().map((Post)->this.modelMapper.map(Post, PostDto.class)).collect(Collectors.toList());
-				
-				// comes from PostResponse.Class
-				PostResponse postResponse = new PostResponse();
-				postResponse.setContent(postDtos);
-				postResponse.setPageNumber(pagePost.getNumber());
-				postResponse.setPageSize(pagePost.getSize());
-				postResponse.setTotalElements(pagePost.getTotalElements());
-				postResponse.setTotalPages(pagePost.getTotalPages());
-				postResponse.setLastPage(pagePost.isLast());
-				
-				return postResponse;
-			}
11.Searching
URL : http://localhost:8080/api/posts/search/lak
PostRepo – 
-	List<Post> findByTitleContaining(String title);
-	              // findByTitleContaining method gives error because of hibernate version.
-		// @Query("select p from Post p where p.title like :key")
-		// List<Post> searchByTitle(@Param("key") String title);
PostService – 
-	List<PostDto> searchPosts(String keyword);
PostServiceImpl – 
-		public List<PostDto> searchPosts(String keyword) {
-			List<Post> posts = this.postRepo.findByTitleContaining(keyword);
-	//		List<Post> posts = this.postRepo.searchByTitle("%"+keyword+"%"); - not used
-			List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
-			return postDtos;
-		}
PostController – 
-	               // Search post
-		@GetMapping("/posts/search/{keywords}")
-		public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("Keywords") String Keywords){
-			List<PostDto> result = this.postService.searchPosts(Keywords);
-			return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
-		}
12.Created new CLASS AppConstants.Class for Constants used in getAllPost in controller.
13.Image Upload
POSTMAN:
-	To upload Image
-	Body -> form data -> key(give name same as used in Class) -> Value(select Image).
-	Key name should be same as used in Controller.Class argument->@RequestParam(“image”)
-	Check above
Application.properties:
-	# File related all configuration - upload File and serve
-	spring.servlet.multipart.max-file-size=10MB
-	spring.servlet.multipart.max-request-size=10MB
-	
-	#Path - for file/image
-	project.image=images/
FileService:
-	public interface FileService {
-		String uploadImage(String path, MultipartFile file) throws IOException;
-	
-	    // to serve the image (show on webpage)
-	    InputStream getResource(String path, String fileName) throws FileNotFoundException;
-	}
FileServiceImpl:
-	
-	@Service
-	public class FileServiceImpl implements FileService {
-	
-		@Override
-		public String uploadImage(String path, MultipartFile file) throws IOException {
-			
-			// file name
-			String name = file.getOriginalFilename();
-			
-			// abc.png
-	
-	        // created random name.
-	        // new name for each uploaded pic.
-	        String randomId= UUID.randomUUID().toString();
-	        String fileName1=randomId.concat(name.substring(name.lastIndexOf(".")));
-	
-	        // full path
-	        String filePath = path + File.separator + fileName1;
-	
-	        //create folder if not created
-	        File f = new File(path);
-	        if(!f.exists()){
-	            f.mkdir();
-	        }
-	
-	        //file copy
-	        Files.copy(file.getInputStream(), Paths.get(filePath));
-	
-	        return fileName1;
-		}
-	
-		@Override
-		public InputStream getResource(String path, String fileName) throws FileNotFoundException {
-			String fullPath = path+File.separator+fileName;
-	        InputStream is = new FileInputStream(fullPath);
-	        return is;
-		}
-	
-	}
No Need to create file Controller.(for image upload)
Created API for File in PostController.Class.
PostController:
-	// post image upload 
-		@PostMapping("/post/image/upload/{postId}")
-		public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image, @PathVariable("postId") Integer postId) throws IOException {
-			PostDto postDto = this.postService.getPostById(postId);
-			String fileName = this.fileService.uploadImage(path, image);
-			postDto.setImageName(fileName);
-			PostDto updatePost = this.postService.updatePost(postDto, postId);
-			return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
-		}
-		
-		// to serve the image (show on webpage)
-	    // search on Chrome
-	    @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
-	    public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
-	        InputStream resource = this.fileService.getResource(path, imageName);
-	        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
-	        StreamUtils.copy(resource, response.getOutputStream());
-	    }
14. Created Comment API
15. Spring Security
- POSTMAN
- Basic Authorization
- POSTMAN -> Authorization -> Basic Authorization -> username & Password
-     POM.XML
-                           <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
-	Application.properties – no need when we use JWT – no need when we user user datails
-	logging.level.org.springframework.security=DEBUG
-	spring.security.user.name=akshay
-	spring.security.user.password=12345
-	spring.security.user.roles=ADMIN
-	.

1.Created Role.Class
- @Entity
@Data (@getter & @Setter)
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
}
2. In User.Class Added below method.
@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//@JoinTable will create separate table(user,role)
//joinColumns - comes from user.Class
//inverseJoinColumns - comes from Role.Class
@JoinTable(name="user_roll",
joinColumns = @JoinColumn(name="user",referencedColumnName = "id"),
inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "id"))
private Set<Role> roles = new HashSet<>();
}
-	Basic Authorization:
-	In SecurityConfig.Class.
-	
-	@Configuration
-	@EnableWebSecurity
-	public class SecurityConfig{
-		
-		@Bean
-		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
-			
-			http.csrf()
-			.disable()
-			.authorizeHttpRequests()
-			.anyRequest()
-			.authenticated()
-			.and()
-			.httpBasic();
-			
-			DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
-			return defaultSecurityFilterChain;
-			}
-	.
-	
-	In SecurityConfig.Class create below methods.
-	1- Add SecurityFilterChain (method) - @Bean.
-	2- AuthenticationManager (method) - @Bean.
-	3- DaoAuthenticationProvider (method) -@Bean.
-	4- PasswordEncoder (method) - @Bean.
-	.
3. In UserRepo.Class added below method:
package com.blog.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.blog.Entity.User;
public interface UserRepo extends JpaRepository<User, Integer> {
	// created for Security Email is UserId to login.
	// used in CustomUserDetailService.Class
	Optional<User> findByEmail(String email);
}
4. In User.Class Implemented UserDetails
And added unimplemented methods listed below.
- package com.blog.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements UserDetails{
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@Column(name="user_name", nullable = false, length = 100)
private String name;

private String email;
private String password;
private String about;

//MappedBy=User(Post.class->user column)
//this column will not create.
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Post> posts = new ArrayList<>();

@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//@JoinTable will create separate table(user,role)
//joinColumns - comes from user.Class
//inverseJoinColumns - comes from Role.Class
@JoinTable(name="user_roll",
joinColumns = @JoinColumn(name="user",referencedColumnName = "id"),
inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "id"))
private Set<Role> roles = new HashSet<>();

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	List<SimpleGrantedAuthority> authorities = this.roles.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	return authorities;
}
@Override
public String getUsername() {
	return this.email;
}
@Override
public boolean isAccountNonExpired() {
	return true;
}
@Override
public boolean isAccountNonLocked() {
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	return true;
}
@Override
public boolean isEnabled() {
	return true;
}
}
5.Created CustomUserDetailService.Class
-	package com.blog.security;
-	
-	import org.springframework.beans.factory.annotation.Autowired;
-	import org.springframework.security.core.userdetails.UserDetails;
-	import org.springframework.security.core.userdetails.UserDetailsService;
-	import org.springframework.security.core.userdetails.UsernameNotFoundException;
-	
-	import com.blog.Entity.User;
-	import com.blog.exceptions.ResourceNotFoundException;
-	import com.blog.repository.UserRepo;
-	
-	public class CustomUserDetailService implements UserDetailsService  {
-	
-		@Autowired
-		private UserRepo userRepo;
-		@Override
-		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
-			
-			// loding user from database by username.
-			User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "email : "+username, 0));
-			return user;
-		}
-	
-	}
1.	Created SecurityConfig.Class
-	package com.blog.config;
-	
-	import org.springframework.beans.factory.annotation.Autowired;
-	import org.springframework.context.annotation.Bean;
-	import org.springframework.context.annotation.Configuration;
-	import org.springframework.http.HttpMethod;
-	import org.springframework.security.authentication.AuthenticationManager;
-	import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
-	import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
-	import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
-	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
-	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
-	import org.springframework.security.config.http.SessionCreationPolicy;
-	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
-	import org.springframework.security.crypto.password.PasswordEncoder;
-	import org.springframework.security.web.DefaultSecurityFilterChain;
-	import org.springframework.security.web.SecurityFilterChain;
-	import org.springframework.web.servlet.config.annotation.EnableWebMvc;
-	
-	import com.blog.security.CustomUserDetailService;
-	
-	@Configuration
-	@EnableWebSecurity
-	@EnableWebMvc
-	@EnableGlobalMethodSecurity(prePostEnabled = true)
-	public class SecurityConfig{
-		
-		@Autowired
-		private CustomUserDetailService customUserDetailService;
-		
-		@Bean
-		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
-			
-			http.csrf()
-			.disable()
-			.authorizeHttpRequests()
-			.anyRequest()
-			.authenticated()
-			.and()
-			.httpBasic();
-			
-	                             http.authenticationProvider(daoAuthenticationProvider());
-			DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
-			return defaultSecurityFilterChain;
-					
-		}
-		
-		
-		@Bean
-		public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
-			return configuration.getAuthenticationManager();	
-		}
-		
-		@Bean
-		public DaoAuthenticationProvider daoAuthenticationProvider() {
-			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
-			provider.setUserDetailsService(this.customUserDetailService);
-			provider.setPasswordEncoder(passwordEncoder());
-			return provider;
-		}
-		
-		@Bean
-		public PasswordEncoder passwordEncoder() {
-			return new BCryptPasswordEncoder();
-		}
-	
-	}

JWT Authentication-
POSTMAN:
In Authorization – select No Auth
In Header – key(Authorization) – value(Token start with Bearer)

JWT Dependency:
<! -- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>

Binding dependency
<! -- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.4.0-b180830.0359</version>
</dependency>


Architecture of JWT:
-	Header- algo + type
-	Payload- information about claims (sub,name)
-	Signature- encoded header + encoded payload + key
8 Steps to implement JWT Auth.
1-	Add Dependency (io.jsonwebtoken jjwt)
2-	Create JWTAuthenticationEntryPoint implements AuthenticationEntryPoint.
3-	Create JWTTokenHelper.
4-	JWTAuthenticationFilter extends OnceRequestFilter – if we get error in this class will get Exception (AuthenticationEntryPoint.Class will run  as Exception)
// 1 get the token
// In Postman -> Header you have to mention same 
String requestToken = request.getHeader("Authorization");

-	Get JWT token from request. – will get token 
-	Validate token.
-	Get user from token.
-	Load user associated with token.
-	Set spring security.
5-	Create JWTAuthResponse. – used to return token only.
6-	Configure JWT in spring security config.
7-	Create login API to return token.(AuthController)
8-	Test the application.

1.	Add Dependency (io.jsonwebtoken jjwt)
-	<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
-	<dependency>
-	    <groupId>io.jsonwebtoken</groupId>
-	    <artifactId>jjwt</artifactId>
-	    <version>0.9.1</version>
-	</dependency>
-	
2.	Create JWTAuthenticationEntryPoint implements AuthenticationEntryPoint.
-	Commence.method will execute when - unauthorized person try to access Authorize API’S.
-	Here we have to send only unauthorized status.
-	In security.package
-	.
-	package com.blog.security;
-	
-	import java.io.IOException;
-	
-	import org.springframework.security.core.AuthenticationException;
-	import org.springframework.security.web.AuthenticationEntryPoint;
-	import org.springframework.stereotype.Component;
-	
-	import jakarta.servlet.ServletException;
-	import jakarta.servlet.http.HttpServletRequest;
-	import jakarta.servlet.http.HttpServletResponse;
-	
-	@Component
-	public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
-	
-		@Override
-		public void commence(HttpServletRequest request, HttpServletResponse response,
-				AuthenticationException authException) throws IOException, ServletException 
-		{
-			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denined !!");
-		}
-	}
-	.
3.	Create JWTTokenHelper.
-	Copy pasted code
-	In security.package
-	.
-	package com.blog.security;
-	
-	import org.springframework.stereotype.Component;
-	
-	import io.jsonwebtoken.Claims;
-	import io.jsonwebtoken.Jwts;
-	import io.jsonwebtoken.SignatureAlgorithm;
-	import org.springframework.security.core.userdetails.UserDetails;
-	import java.util.Date;
-	import java.util.HashMap;
-	import java.util.Map;
-	import java.util.function.Function;
-	
-	@Component
-	public class JwtTokenHelper {
-	
-	    //requirement :
-	    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
-	
-	    //    public static final long JWT_TOKEN_VALIDITY =  60;
-	    private String secret = "jwtTokenKey";
-	
-	    //retrieve username from jwt token
-	    public String getUsernameFromToken(String token) {
-	        return getClaimFromToken(token, Claims::getSubject);
-	    }
-	
-	    //retrieve expiration date from jwt token
-	    public Date getExpirationDateFromToken(String token) {
-	        return getClaimFromToken(token, Claims::getExpiration);
-	    }
-	
-	    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
-	        final Claims claims = getAllClaimsFromToken(token);
-	        return claimsResolver.apply(claims);
-	    }
-	
-	    //for retrieveing any information from token we will need the secret key
-	    private Claims getAllClaimsFromToken(String token) {
-	        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
-	    }
-	
-	    //check if the token has expired
-	    private Boolean isTokenExpired(String token) {
-	        final Date expiration = getExpirationDateFromToken(token);
-	        return expiration.before(new Date());
-	    }
-	
-	    //generate token for user
-	    public String generateToken(UserDetails userDetails) {
-	        Map<String, Object> claims = new HashMap<>();
-	        return doGenerateToken(claims, userDetails.getUsername());
-	    }
-	
-	    //while creating the token -
-	    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
-	    //2. Sign the JWT using the HS512 algorithm and secret key.
-	    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
-	    //   compaction of the JWT to a URL-safe string
-	    private String doGenerateToken(Map<String, Object> claims, String subject) {
-	
-	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
-	                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
-	                .signWith(SignatureAlgorithm.HS512, secret).compact();
-	    }
-	
-	    //validate token
-	    public Boolean validateToken(String token, UserDetails userDetails) {
-	        final String username = getUsernameFromToken(token);
-	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
-	    }
-	}
-	.
4.	JWTAuthenticationFilter extends OnceRequestFilter.
-	In security.package
-	.
-	package com.blog.security;
-	
-	import java.io.IOException;
-	
-	import org.springframework.beans.factory.annotation.Autowired;
-	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
-	import org.springframework.security.core.context.SecurityContextHolder;
-	import org.springframework.security.core.userdetails.UserDetails;
-	import org.springframework.security.core.userdetails.UserDetailsService;
-	import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
-	import org.springframework.stereotype.Component;
-	import org.springframework.web.filter.OncePerRequestFilter;
-	
-	import io.jsonwebtoken.ExpiredJwtException;
-	import io.jsonwebtoken.MalformedJwtException;
-	import jakarta.servlet.FilterChain;
-	import jakarta.servlet.ServletException;
-	import jakarta.servlet.http.HttpServletRequest;
-	import jakarta.servlet.http.HttpServletResponse;
-	
-	@Component
-	public class JwtAuthenticationFilter extends OncePerRequestFilter {
-	
-		@Autowired
-		private UserDetailsService userDetailsService;
-		
-		@Autowired
-		private JwtTokenHelper jwtTokenHelper;
-		
-		@Override
-		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
-				throws ServletException, IOException {
-			
-			// 1 get the token
-			String requestToken = request.getHeader("Authorization");
-			
-			// Bearer 23445gfgt
-			
-			System.out.println(requestToken);
-			
-			String username = null;
-			String token = null;
-			
-			if(requestToken != null && requestToken.startsWith("Bearer")) {
-				token = requestToken.substring(7);
-				
-				try {
-				username = this.jwtTokenHelper.getUsernameFromToken(token);
-				}catch(IllegalArgumentException e) {
-					System.out.println("Unable to get JWT Token.");
-				}catch(ExpiredJwtException e) {
-					System.out.println("Jwt token has Expired");
-				}catch(MalformedJwtException e) {
-					System.out.println("Invalid JWT");
-				}
-				
-			}else {
-				System.out.println("JWT Token does not start with Bearer !");
-			}
-			
-			// once we get the token, now validate
-			if(username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
-				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
-				if(this.jwtTokenHelper.validateToken(token, userDetails)) 
-				{
-					// sahi chal raha he
-					//Authentication krna he
-					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
-					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
-					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
-					
-				}else {
-					System.out.println("Invalid JWT Token");
-				}
-			}else {
-				System.out.println("username is null or context is not null");
-			}
-			
-			filterChain.doFilter(request, response);
-		}
-	}
-	.
5.	Create JWTAuthResponse
-	In payload.package
-	.
-	package com.blog.payloads;
-	
-	import lombok.Data;
-	
-	@Data
-	public class JwtAuthResponse {
-	
-		private String token;
-	}
-	.
6.	Configure JWT in spring security config.
-	In config.package
-	.
-	package com.blog.config;
-	
-	import org.springframework.beans.factory.annotation.Autowired;
-	import org.springframework.context.annotation.Bean;
-	import org.springframework.context.annotation.Configuration;
-	import org.springframework.security.authentication.AuthenticationManager;
-	import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
-	import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
-	import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
-	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
-	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
-	import org.springframework.security.config.http.SessionCreationPolicy;
-	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
-	import org.springframework.security.crypto.password.PasswordEncoder;
-	import org.springframework.security.web.DefaultSecurityFilterChain;
-	import org.springframework.security.web.SecurityFilterChain;
-	import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
-	import org.springframework.web.servlet.config.annotation.EnableWebMvc;
-	
-	import com.blog.security.CustomUserDetailService;
-	import com.blog.security.JwtAuthenticationEntryPoint;
-	import com.blog.security.JwtAuthenticationFilter;
-	
-	@Configuration
-	@EnableWebSecurity
-	//@EnableWebMvc
-	//@EnableGlobalMethodSecurity(prePostEnabled = true)
-	public class SecurityConfig{
-		
-		@Autowired
-		private CustomUserDetailService customUserDetailService;
-		
-		@Autowired
-		private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
-		
-		@Autowired
-		private JwtAuthenticationFilter jwtAuthenticationFilter;
-		
-		@Bean
-		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
-			
-			http.csrf()
-			.disable()
-			.authorizeHttpRequests()
-	//		.antMatchers("/api/v1/auth/login").permitAll() - deprecated
-			.requestMatchers("/api/v1/auth/login").permitAll()
-			.anyRequest()
-			.authenticated()
-			.and()
-			.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
-			.and()
-			.sessionManagement()
-			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
-			
-			http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
-			
-			http.authenticationProvider(daoAuthenticationProvider());
-			DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
-			return defaultSecurityFilterChain;
-			
-			
-	//		http.csrf()
-	//		.disable()
-	//		.authorizeHttpRequests()
-	//		.antMatchers(PUBLIC_URLS)
-	//		.permitAll()
-	//		.antMatchers(HttpMethod.GET)
-	//		.permitAll()
-	//		.anyRequest()
-	//		.authenticated()
-	//		.and()
-	//		.exceptionHandeling()
-	//		.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
-	//		.and()
-	//		.sessionManagement()
-	//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
-			
-	//		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePassword) 
-	//		http.authenticationProvider(daoAuthenticationProvider());
-	//		DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
-	//		return defaultSecurityFilterChain;
-			
-		}
-		
-		
-		@Bean
-		public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
-			return configuration.getAuthenticationManager();	
-		}
-		
-		@Bean
-		public DaoAuthenticationProvider daoAuthenticationProvider() {
-			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
-			provider.setUserDetailsService(this.customUserDetailService);
-			provider.setPasswordEncoder(passwordEncoder());
-			return provider;
-		}
-		
-		@Bean
-		public PasswordEncoder passwordEncoder() {
-			return new BCryptPasswordEncoder();
-		}
-	
-	}
-	.
-	Created JwtAuthRequest.Class in payload.package
-	Created JwtAuthResponse.Class in payload.package
-	
7.	Create login API to return token.
-	Created AuthController.Class in controller.package
package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.JwtAuthRequest;
import com.blog.payloads.JwtAuthResponse;
import com.blog.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		
		this.authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
		
	}

	private void authenticate(String username, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		try {
		this.authenticationManager.authenticate(authenticationToken);
		}catch(BadCredentialsException e) {
			System.out.println("Invalid Details !!");
			throw new Exception("invalid username or password!");
		}
		
	}
}
Role Specific API Access
Check Role and user_roll table only ADMIN have assigned the permission to create API’s.
1.	In UserController.Class
                    // delete user rest API
	// Created new ApiResponse Class to show deleted message
	// Only Admin can delete User
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
	this.userService.deleteUser(userId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully", true),HttpStatus.OK);
	}
2.	In SecurityConfig.Class
Annotate with - @EnableGlobalMethodSecurity(prePostEnabled = true)

@Configuration
@EnableWebSecurity
//@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
	@Autowired
	private CustomUserDetailService customUserDetailService;
Login -> get TOKEN -> Try to DELETE

Register API’s (NORMAL/ADMIN)
1.	Created RoleRepo.Class
2.	Created Role.Class (Entity)
3.	In AppConstants.Class added - public static final Integer ADMIN_USER=501;
                                                       public static final Integer NORMAL_USER=502;
4.	In UserService.Class added - UserDto registerNewUser(UserDto user);
5.	In UserServiceImpl.Class – 
// Create new user role based ADMIN/NORMAL
	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		//encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		//roles
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		user.getRoles().add(role);
		User newUser = this.userRepo.save(user);
		return this.modelMapper.map(newUser, UserDto.class);
	}
6.	In BlogAppApisApplication.Class –  it will create role at starting (ADMIN/NORMAL)
// RUN METHOD
	@Override
	public void run(String... args) throws Exception {
		
		//to show Encrypted password only
		System.out.println(this.passwordEncoder.encode("maxpayne"));
		
		//create new Role(table)
		try {
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ADMIN_USER");
			
			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("NORMAL_USER");
			
			List<Role> roles = List.of(role,role1);
			List<Role> result = this.roleRepo.saveAll(roles);
			result.forEach(r->{System.out.println(r.getName());});
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
7.	AuthController.Class – 
//register new user API.
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		UserDto registeredNewUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDto>(registeredNewUser,HttpStatus.CREATED);	
	}
8.	Allow it from SecurityConfig.Class-
                       .requestMatchers("/api/v1/auth/**").permitAll()
9.	Added private Set<RoleDto> roles = new HashSet<>(); in UserDto.Class.
Created RoleDto.Class

16. Documenting API’s using swagger
API Documentation:
1.	Download dependency 
-	Search on chrome – “springdoc migration”. 
-	
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.3.0</version>
   </dependency>

2.	In SecurityConfig.Class
-	Add annotation @EnableWebMvc 
-	Add in securityFilterChain.method .requestMatchers("/v3/api-docs").permitAll()
-	No need of above line.
public static final String[] PUBLIC_URLS= {
			"/api/v1/auth/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
			};
-	Add in securityFilterChain.method.requestMatchers(PUBLIC_URLS).permitAll()
Run on chrome
http://localhost:8080/swagger-ui/index.html

Add Name and Descriptions to API’s using TAG
-	In all controller use this TAG
@Tag(name="Auth Controller", description = "API's for Authentication")
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/v1/auth/")
@Tag(name="Auth Controller", description = "API's for Authentication")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
Customize Api document – give project name and details about project.
1.	Created SwaggerConfig.Class

package com.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	  public OpenAPI springShopOpenAPI() {
	        return new OpenAPI()
	                .info(new Info().title("Blog Application")
	                .description("Upload pics, give comment")
	                .version("v0.0.1")
	                .contact(new Contact().name("Akshay").email("shewaleakshay1996@gmail.com").url("ravan.com"))
	                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	                .externalDocs(new ExternalDocumentation()
	                .description("ex - SpringShop Wiki Documentation")
	                .url("ex - https://springshop.wiki.github.org/docs"));
	    }
}
2.	Added in application.properties
#API Documentation
springdoc.packagesToScan = com.blog.controller
springdoc.pathsToMatch = /api/**, /auth/**, /v1, /v2, /v3, /categories/**, /comments/**, /posts/**, /users/**
Run on chrome
http://localhost:8080/swagger-ui/index.html
Add Spring Security in swagger. To get Token
1.	Using Class Bean
Added new method in SwaggerConfig.Class
package com.blog.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
	@Bean
	  public OpenAPI springShopOpenAPI() {
		String schemeName = "bearerScheme";
	        return new OpenAPI()
	        		.addSecurityItem(new SecurityRequirement()
	        				.addList(schemeName))
	        		.components(new Components()
	        				.addSecuritySchemes(schemeName, new SecurityScheme()
	        						.name(schemeName)
	        						.type(SecurityScheme.Type.HTTP)
	        						.bearerFormat("JWT")
	        						.scheme("bearer")
	        						))
	        		
	                .info(new Info().title("Blog Application")
	                .description("Upload pics, give comment")
	                .version("v0.0.1")
	                .contact(new Contact().name("Akshay").email("shewaleakshay1996@gmail.com").url("ravan.com"))
	                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	                .externalDocs(new ExternalDocumentation()
	                .description("ex - SpringShop Wiki Documentation")
	                .url("ex - https://springshop.wiki.github.org/docs"));
	    }
}
2.	Using Annotation
Annotate the SwaggerConfig.Class
package com.blog.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
// add security in swagger - using annotation
@io.swagger.v3.oas.annotations.security.SecurityScheme(
		name="bearerScheme",
		type=SecuritySchemeType.HTTP,
		bearerFormat="JWT",
		scheme="bearer"
		)
@OpenAPIDefinition(
		info=@io.swagger.v3.oas.annotations.info.Info(
				title="Blog Application",
                description="Upload pics, give comment",
                version="v0.0.1",
                contact=@io.swagger.v3.oas.annotations.info.Contact(
                		name="Akshay Shewale ",
                		email="shewaleakshay1996@gmail.com",
                		url="ravan.com"
                		),
                license = @io.swagger.v3.oas.annotations.info.License(
                		name="Apache 2.0 - Open License",
                		url="http://springdoc.org"
                		)
                		),
		externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
				description="ex - SpringShop Wiki Documentation",
                url="ex - https://springshop.wiki.github.org/docs"
				)
                )
public class SwaggerConfig {

Add in All controller.Class
//Spring security - API Documentation (SwaggerConfig.CLass)
@SecurityRequirement(name="bearerScheme")


17. Deployment on AWS
1.	Managing different Environments.
-	Development Environment (Local - localhost)
-	Production Environment (AWS)
-	.
-	Create new application-dev.properties file in resources.
-	Create new application-prod.properties file in resources.
-	.
-	To run dev or prod environment In application.properties write.
-	spring.profiles.active=dev
-	run the project and check on console it will show on 2nd line 
-	The following 1 profile is active: "dev"
-	.
2.	Login to AWS (AWS Elastic Beanstalk)
-	AWS Elastic Beanstalk – no need to install java and SQL everything is inbuild.
-	RDS – relational database system.
-	AMAZON route 53 – Domain name system
-	AMAZON S3 – Cloud storage.
-	.
-	To signup on chrome – AWS console.
Application-dev.properties
#DB Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_apis
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.show-sql=true
Application-prod.properties
#DB Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_apis
spring.datasource.username=
spring.datasource.password=
Application.properties
#DB Configuration - (dev-prod)
#spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_apis
#spring.datasource.username=root
#spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

#Hibernet auto DDL create, update, create-drop, validate
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true

# File related all configuration - upload File and serve
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

#Path - for file/image
project.image=images/

#Security
logging.level.org.springframework.security=DEBUG
#No need comes from Database:
#spring.security.user.name=akshay
#spring.security.user.password=12345
#spring.security.user.roles=ADMIN

#API Documentation - Swagger
springdoc.packagesToScan=com.blog.controller
springdoc.pathsToMatch=/api/**, /auth/**, /v1, /v2, /v3, /categories/**, /comments/**, /posts/**, /users/**

spring.profiles.active=dev

.
.
. not completed
18. JSON to XML
1.	Add dependency.
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml -->
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
    <version>2.16.0</version>
</dependency>

2.	Create ContentConfig.Class in config.package.
              package com.blog.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ContentConfig implements WebMvcConfigurer {
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true)
		.parameterName("mediaType")
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);
	}
}
3.	In POSTMAN
After URL attach “?mediaType=json/xml”
By default, it is json.
              http://localhost:8080/api/categories/?mediaType=xml

============================================================================================
Pagination for findByUser and findByCategory.
For token generation Exception not seen on POSTMAN (can see on STS console)

============================================================================================


