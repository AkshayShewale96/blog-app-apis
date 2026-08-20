React-
1.	Download & Install Node.js
2.	Check node version On Command Prompt (cmd) type node -v
3.	Check npm version On Command Prompt (cmd) type npm -v
4.	.
5.	Website – create new react app.
6.	Create project – go to folder location and open cmd.
7.	In cmd type – npx create-react-app blog-app
8.	Cd blog-app
9.	Run the App – npm start
10.	http://localhost:3000
11.	…………………………………………………………………………………..
12.	Architecture of ReactJs- Folder Structure
13.	Node_modules – it contains dependencies - all dependencies are installed.
14.	Package.json - it contains dependencies.
15.	Public – it contains index.html – only one html page in react.
16.	. src – it is mostly used folder.
17.	 – index.js – starting point of react.
18.	-  App.js – we can start coding here.
19.	………
20.	When we hit npm start
21.	 index.html(public) file is served. (it contains root dom node)
22.	index.js – control enters in, it renders Component App.
23.	App.js – it contains html which is displayed on the browser.
24.	………
25.	Components
26.	->Header
27.	->Footer
28.	->side Nav.
29.	->Main content.
30.	->root App component
31.	……………………………………………………………………………………
32.	HTML-CSS-Bootstrap
33.	Search – reactstrap 
34.	Reactstrap.github.io
35.	.
36.	To install bootstrap in react - npm install reactstrap react react-dom
37.	And install - npm install --save bootstrap
38.	Import in component - import 'bootstrap/dist/css/bootstrap.min.css';
39.	Pest this import in App.js
40.	========================================================================================
41.	.
42.	DO this 
43.	.Created two folder in src
44.	1st is Components.
45.	--- Base.js – is a master contain Header – Children – Footer
46.	.
47.	const Base =({title="welcome to our website",children})=>{
48.	    return(
49.	        <div className="container-fluid p-0, m-0">
50.	
51.	            <h1>this is header</h1>
52.	
53.	            {children}
54.	
55.	            <h1>this is footer</h1>
56.	        </div>
57.	    );
58.	};
59.	export default Base;
60.	.
61.	2nd is Pages.
62.	.pages contain login, signup, about…………..
63.	Within base write everything.
64.	.
65.	========================================================================================
66.	.
67.	Routing to another component/page
68.	Search – react router dom
69.	Reactrouter.com
70.	 - npm install react-router-dom localforage match-sorter sort-by
71.	.
72.	1. In Base.js –
73.	const Base =({title="welcome to our website",children})=>{
74.	    return(
75.	        <div className="container-fluid p-0, m-0">
76.	
77.	            <h1>this is header</h1>
78.	
79.	            {children}
80.	
81.	            <h1>this is footer</h1>
82.	        </div>
83.	    );
84.	};
85.	export default Base;
86.	2. In App.js –
87.	 import { BrowserRouter, Routes, Route } from 'react-router-dom';
88.	.
89.	import logo from './logo.svg';
90.	import 'bootstrap/dist/css/bootstrap.min.css';
91.	import './App.css';
92.	import Base from './components/Base';
93.	import { BrowserRouter, Routes, Route } from 'react-router-dom';
94.	import Signup from './pages/Signup';
95.	import Login from './pages/Login';
96.	import Home from './pages/Home';
97.	import About from './pages/About';
98.	
99.	function App() {
100.	  return (
101.	   
102.	   <BrowserRouter>
103.	   <Routes>
104.	
105.	    <Route path="" element={<Home/>}/>
106.	    <Route path="/login" element={<Login/>}/>
107.	    <Route path="/signup" element={<Signup/>}/>
108.	    <Route path="/about" element={<About/>}/>
109.	
110.	   </Routes>
111.	   </BrowserRouter>
112.	
113.	  );
114.	}
115.	export default App;.
116.	.
117.	Create the Login.js, Signup.js, About.js pages.
118.	.
119.	=================================================================================================
120.	.
121.	VS Setting
122.	JSX or HTML autocompletion in Visual Studio Code- Emmet.
123.	Search - Jsx auto complete.
124.	Pest this part int VS setting -> open setting (js) {setting.js}
125.	"emmet.triggerExpansionOnTab": true,
126.	"emmet.includeLanguages": {
127.	  "javascript": "javascriptreact"
128.	}
129.	.
130.	VS Setting
131.	Auto import component
132.	Need to add Plugin in VS 
133.	Search in plugin -> React
134.	ES7+ React/Redux/React-Native snippets
135.	Prettier - Code formatter
136.	.
137.	=================================================================================================
138.	.
139.	Navbar
140.	Search – reactstrap
141.	Reactstrap.github.io
142.	Search for navbar and copy.
143.	.
144.	Create CustomNavbar.js in Component.folder
145.	Pest code in it—
146.	----code---
147.	.
148.	Use in Base.js – 
149.	.
150.	import CustomNavbar from "./CustomNavbar";
151.	
152.	const Base =({title="welcome to our website",children})=>{
153.	    return(
154.	        <div className="container-fluid p-0, m-0">
155.	
156.	            <CustomNavbar/>
157.	
158.	            {children}
159.	
160.	            <h1>this is footer</h1>
161.	        </div>
162.	    );
163.	};
164.	export default Base;
165.	.
166.	When we want to use Navbar in login page
167.	In Login.js in all pages.
168.	import Base from "../components/Base";
169.	
170.	const Login =()=>{
171.	    return(
172.	        <Base>
173.	        <div>
174.	            <h1>This is Login page</h1>
175.	            <p>welcome to Login page</p>
176.	        </div>
177.	        </Base>
178.	    );
179.	};
180.	export default Login
181.	.
182.	Add a href=”” in CustomNavbar.js
183.	Need to -  import { NavLink as ReactLink } from 'react-router-dom';
184.	<NavItem> <NavLink tag={ReactLink} to="/about"  >About</NavLink> </NavItem>.
185.	.
186.	And need to mention in App.js
187.	<Route path="/login" element={<Login/>}/>
188.	.
189.	=================================================================================================
190.	.
191.	Signup form
192.	You can copy from reactstrap also.
193.	Create Signup.js in Pages.folder
194.	Everything should be in <Base> only, will get header and footer from <Base>.
195.	
196.	.Signup.js
197.	1st create a function.
198.	.const Signup =()=>{
199.	.return(  “write all code here” )
200.	}
201.	.export default Signup
202.	..
203.	---------------------------------------------
204.	In return -> Base -> Container -> Row -> Col -> Card -> CardHeader -> CardBody -> From.
205.	Row -> <Row className="mt-4"> || mt=margin top. Varun 4px ne jaga sutel.
206.	Col -> <Col sm={{size:6, offset:3}}> || sm= start margin – middle la form banel || size:6-6 column cha form banel || offset:3 – 2g side ne 3-3 column chi jaga mokli asel.
207.	.CardBody made form create karaycha –
208.	{/* Name Field */}
209.	<FormGroup>
210.	  <Label for="name">Enter Name</Label>
211.	   <Input type="text" placeholder="Enter here" id="name" />
212.	</FormGroup>
213.	.
214.	
215.	=================================================================================================
216.	.
217.	Two way data binding
218.	.In .Signup Form
219.	. to store data temporary will create variable.
220.	Before return(
221.	.const[data, setData]=useState({}) –data is a variable, setData is a function-fields same as backend class.
222.	. const[data, setData]=useState({
223.	        name:'',
224.	        email:'',
225.	        password:'',
226.	        about:''
227.	    })
228.	.and created handler method – if we change name on website above object will change
229.	. // handle Change
230.	    const handleChange=(event)=>{
231.	        setData({...data,name:event.target.value})
232.	    }
233.	.and mention this function in name field.
234.	<FormGroup>
235.	<Label for="name">Enter Name</Label>
236.	<Input type="text"
237.	 placeholder="Enter here"
238.	 id="name"
239.	 onChange={(e)=>handleChange(e)} />
240.	</FormGroup>
241.	.
242.	.to see on console, need to define one more function
243.	useEffect(()=>{
244.	console.log(data);
245.	},[data])
246.	..
247.	For Dynamic change/binding (one way)
248.	In handler method
249.	// handle Change
250.	    const handleChange=(event,property)=>{
251.	    setData({...data,[property]:event.target.value})
252.	    }
253.	.
254.	In name field
255.	<FormGroup>
256.	<Label for="name">Enter Name</Label>
257.	<Input type="text"
258.	 placeholder="Enter here"
259.	 id="name"
260.	 onChange={(e)=>handleChange(e,'name')} />
261.	</FormGroup>
262.	.
263.	For two-way data binding
264.	In name field
265.	.. <FormGroup>
266.	<Label for="name">Enter Name</Label>
267.	<Input type="text"
268.	 placeholder="Enter here"
269.	 id="name"
270.	 onChange={(e)=>handleChange(e,'name')}
271.	 value={data.name}/>
272.	</FormGroup>
273.	.
274.	just checking purpose- print data on form
275.	..{JSON.stringify(data)}
276.	..
277.	To reset the form
278.	.create a function in RESET button
279.	<Button onClick={resetData} color="secondary" className="ms-2" type="reset">Reset</Button>
280.	.
281.	And created a function for reset.
282.	const resetData=()=>{
283.	        setData({
284.	        name:'',
285.	        email:'',
286.	        password:'',
287.	        about:''
288.	        })
289.	    }
290.	..
291.	To submit the form
292.	..add in the Form tag
293.	<form onSubmit={submitForm}>
294.	..
295.	And create a function.
296.	const submitForm =(event)=>{
297.	        event.preventDefault()
298.	        console.log(data)
299.	 // data validate
300.	 //call server API for sending data
301.	    }
302.	.
303.	=================================================================================================
304.	.
305.	Connected with backend to submit Signup form.
306.	.
307.	To call the server we need one API so we are using axios Library to call the server.
308.	.
309.	And to show success/Error message we are using toastify Library.
310.	.
311.	..Axios – search on chrome - https://axios-http.com/docs/intro 
312.	 npm install axios
313.	
314.	.Toastify – search on chrome - https://www.npmjs.com/package/react-toastify
315.	. npm install --save react-toastify 
316.	.
317.	.Created new folder services – to store constant like base URL
318.	Created helper.js file in services folder. – to store BASE_URL & axios variable.
319.	.
320.	Created user-service.js file in services folder – contain functions to call server user related – get put post delete.
321.	Then use this function in Signup.js form.
322.	.
323.	// submit the form
324.	    const submitForm =(event)=>{
325.	        event.preventDefault()
326.	        console.log(data)
327.	
328.	        // data validate
329.	        //call server API for sending data
330.	        signUp(data).then((resp)=>{
331.	            console.log(resp);
332.	            console.log("success log");
333.	        }).catch((error)=>{
334.	            console.log(error);
335.	            console.log("Error log");
336.	        });
337.	    }
338.	.
339.	To run the app we need CrossOrigin permission. (Spring boot)
340.	..we have two ways to give permission.
341.	1st in AuthController give annotation @CrossOrigin(“*”). Not works properly with Spring Security.
342.	2nd way is to create a @Bean in SecurityConfig.Class - springboot
343.	.
344.	. package com.blog.config;
345.	import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
346.	import org.springframework.web.cors.CorsConfiguration;
347.	import org.springframework.web.cors.CorsConfigurationSource;
348.	import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
349.	import org.springframework.web.filter.CorsFilter;
350.	import org.springframework.web.servlet.config.annotation.EnableWebMvc;
351.	
352.	import com.blog.security.CustomUserDetailService;
353.	import com.blog.security.JwtAuthenticationEntryPoint;
354.	import com.blog.security.JwtAuthenticationFilter;
355.	
356.	@Configuration
357.	@EnableWebSecurity
358.	@EnableWebMvc
359.	@EnableMethodSecurity(prePostEnabled = true)
360.	//@EnableGlobalMethodSecurity(prePostEnabled = true) - deprecated
361.	public class SecurityConfig{
362.		 - - - - - -
363.	                     - - - - - - -
364.	                    Some code
365.		
366.		@Bean
367.		public FilterRegistrationBean coresFilter() {
368.			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
369.			
370.			CorsConfiguration corsConfiguration = new CorsConfiguration();
371.			corsConfiguration.setAllowCredentials(true);
372.			corsConfiguration.addAllowedOriginPattern("*");
373.			corsConfiguration.addAllowedHeader("Authorization");
374.			corsConfiguration.addAllowedHeader("Content-Type");
375.			corsConfiguration.addAllowedHeader("Accept");
376.			corsConfiguration.addAllowedMethod("POST");
377.			corsConfiguration.addAllowedMethod("GET");
378.			corsConfiguration.addAllowedMethod("DELETE");
379.			corsConfiguration.addAllowedMethod("PUT");
380.			corsConfiguration.addAllowedMethod("OPTIONS");
381.			corsConfiguration.setMaxAge(3600L);
382.			
383.			source.registerCorsConfiguration("/**", corsConfiguration);
384.			FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
385.			return bean; 
386.		}
387.	}
388.	.
389.	.Give success message using react toastify
390.	Add this css to App.js –
391.	import { ToastContainer, toast } from 'react-toastify';
392.	 import 'react-toastify/dist/ReactToastify.css';
393.	Add in routes <ToastContainer position='bottom-center' />
394.	.
395.	.and use in Signup.js
396.	.
397.	// submit the form
398.	    const submitForm =(event)=>{
399.	        event.preventDefault()
400.	        console.log(data)
401.	
402.	        // data validate
403.	        //call server API for sending data
404.	        signUp(data).then((resp)=>{
405.	            console.log(resp);
406.	            console.log("success log");
407.	            toast.success("User is registered successfully !!");
408.	            setData({
409.	                name:'',
410.	        email:'',
411.	        password:'',
412.	        about:''
413.	            }) - - - - this will clear all filed data after successfully registration.
414.	        }).catch((error)=>{
415.	            console.log(error);
416.	            console.log("Error log");
417.	        });
418.	    }
419.	.
420.	.=================================================================================================
421.	.
422.	Handling Error messages in react while Signup.
423.	.
424.	Created error variable and function in Signup.js
425.	. const[error, setError]=useState({
426.	        errors:{},
427.	        isError:false
428.	    })
429.	.
430.	.Added in catch – submit form method/function
431.	}).catch((error)=>{
432.	            console.log(error);
433.	            console.log("Error log");
434.	            // handle errors in proper way
435.	            setError({
436.	                errors:error,
437.	                isError:true
438.	            })
439.	        });.
440.	..Added in name field
441.	invalid={error.errors?.response?.data?.name ? true : false} 
442.	.
443.	.Added in name field <FormGroup> - now we can see error message on form directly
444.	<FormFeedback>
445.	 {error.errors?.response?.data?.name}
446.	</FormFeedback>
447.	.
448.	.same did for email, password, about Fields.
449.	.
450.	.=================================================================================================
451.	 In Login.js page we will get JWT Token.
452.	.=================================================================================================
453.	.
454.	
455.	Store JWT Token in Local Storage.
456.	.
457.	Created new folder in src named auth and created page index.js.
458.	.we will create 3 function in index.js
459.	1st is Login.
460.	2nd Do login – data -> set to local storage.
461.	3rd Do Logout – remove from local storage.
462.	.and one more getCurrentUser.
463.	
464.	Use these functions in Login.js.
465.	For doLogin-function
466.	.import in Login.js – 
467.	.
468.	. // handleFormSubmit function
469.	    const handleFormSubmit=(event)=>{
470.	        event.preventDefault();
471.	        console.log(loginDetail);
472.	
473.	        // data validation
474.	        if(loginDetail.username.trim()===0 || loginDetail.password.trim()===0){
475.	            toast.error("Username or Password is required !!")
476.	            return;
477.	        }
478.	        // submit the data to server to generate token
479.	        loginUser(loginDetail).then((data)=>{
480.	            console.log(data)
481.	
482.	            // save the data to local storage
483.	            doLogin(data,()=>{
484.	                console.log("login detail is saved to local storage")
485.	                // redirect to user dashboard page.
486.	            })
487.	
488.	            toast.success("Login success !!")
489.	        }).catch(error=>{
490.	            console.log(error)
491.	            if(error.response.status===400 || error.response.status===404){
492.	                toast.error(error.response.data.message)
493.	            }else{
494.	                toast.error("something is wrong on server !!")
495.	            }
496.	        })
497.	    };
498.	.
499.	………………………SPRING BOOT……………………………………………………………………………………
500.	.added in Spring Boot to give response with User details.
501.	In JwtAuthResponse.Class added – private UserDto user;
502.	In AuthController.Class added – 
503.	// Create TOKEN API.
504.		@PostMapping("/login")
505.		public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
506.			
507.			this.authenticate(request.getUsername(), request.getPassword());
508.			UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
509.			String token = this.jwtTokenHelper.generateToken(userDetails);
510.			
511.			JwtAuthResponse response = new JwtAuthResponse();
512.			response.setToken(token);
513.	//		added for response when we run code on React will get Token and User Details.
514.			response.setUser(this.modelMapper.map((User) userDetails, UserDto.class));
515.			return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);	
516.		}
517.	.if you don’t want to show password.
518.	In UserDto.Class
519.	.. //	Don't show password in response (Frontend-Token and User details)
520.		@JsonIgnore
521.		public String getPassword() {
522.			return this.password;
523.		}
524.	…………………………………………………………………………………………………………………………………….
525.	.
526.	Hide token from response console.
527.	.
528.	=================================================================================================
529.	.
530.	Private Routes in ReactJS – (Nested routes).
531.	. only logged in person can access the website-dashboard, post image.
532.	.
533.	Created folder user-routes in pages folder.
534.	In user-routes folder created a Userdashboard.jsx file.
535.	. just type rfce it will create function (react-functional-component-export)
536.	
537.	. created Privateroute.jsx file in Components folder.
538.	.
539.	. const Privateroute =()=> {
540.	  return isLoggedIn() ? <Outlet/> : <Navigate to={"/login"}/>}
541.	.
542.	<Outlet/> = it will route to the dashboard page. (/user/dashboard) – nested route.
543.	<Navigate to={"/login"} = return to the login page.
544.	.
545.	.in App.js added routes.
546.	function App() {
547.	  return (
548.	   
549.	   <BrowserRouter>
550.	   <ToastContainer position='bottom-center'/>
551.	   <Routes>
552.	
553.	    <Route path="" element={<Home/>}/>
554.	    <Route path="/login" element={<Login/>}/>
555.	    <Route path="/signup" element={<Signup/>}/>
556.	    <Route path="/about" element={<About/>}/>
557.	    <Route path="/services" element={<Services/>}/>
558.	    
559.	    <Route path="/user" element={<Privateroute/>} >
560.	    <Route path="dashboard" element={<Userdashboard/>}/> ---- only logged IN person can access dashboard.
561.	    </Route>
562.	
563.	   </Routes>
564.	   </BrowserRouter>
565.	
566.	  );
567.	}
568.	.
569.	. created ProfileInfo.jsx file in user-routes.
570.	.and added routes in App.js file.
571.	<Route path="/user" element={<Privateroute/>} >
572.	    <Route path="dashboard" element={<Userdashboard/>}/>
573.	    <Route path="profile-info" element={<ProfileInfo/>}/>
574.	    </Route>
575.	. now you can use this ProfileInfo page using URL - …. /user/profile-info.
576.	
577.	=================================================================================================
578.	.
579.	Finishing Login module – after login you can see name on navbar (Conditional Rendering).
580.	.
581.	Before return(
582.	Added in the CustomNavbar.jsx
583.	// this is for Conditional Rendering (after login you can see name on navbar)
584.	  const [login, setLogin] = useState(false)
585.	  const [user, setUser] = useState(undefined)
586.	
587.	  // when component load it will callback function in the useEffect will be call.
588.	  useEffect(()=>{
589.	    setLogin(isLoggedIn())
590.	    setUser(getCurrentUserDetail())
591.	  },[login])
592.	………..
593.	..this also in return(
594.	<Nav navbar>
595.	            {/* logged In - we can see logout & username */}
596.	            {
597.	              // login comes from const [login
598.	              login && (
599.	                <>
600.	                <NavItem>
601.	              <NavLink>
602.	                Logout
603.	              </NavLink>
604.	            </NavItem>
605.	            <NavItem>
606.	              <NavLink>
607.	                {/* // user comes from const [user */}
608.	                {user.email}
609.	              </NavLink>
610.	            </NavItem>
611.	                </>
612.	              )
613.	            }
614.	
615.	          {/* Not logged In - we can see Login & signup */}
616.	          {
617.	            // login comes from const [login
618.	            !login && (
619.	              <>
620.	              <NavItem>
621.	              <NavLink tag={ReactLink} to="/login">
622.	                Login
623.	              </NavLink>
624.	            </NavItem>
625.	            <NavItem>
626.	              <NavLink tag={ReactLink} to="/signup">
627.	                Signup
628.	              </NavLink>
629.	            </NavItem>
630.	              </>
631.	            )
632.	          }
633.	          </Nav>
634.	………………………………………………………………………………………
635.	 Redirect to user dashboard page
636.	..in Login.js page
637.	..
638.	.in const Login =()=>{
639.	// to redirect on dashboard page
640.	    const navigate = useNavigate ()
641.	.
642.	. // save the data to local storage
643.	            doLogin(data,()=>{
644.	                console.log("login detail is saved to local storage")
645.	                // redirect to user dashboard page.
646.	                navigate("/user/dashboard")
647.	            })
648.	.-----------------------------------------------------------------------
649.	..----------------------------------------------------------------------
650.	..for logout
651.	In CustomNavbar.jsx page before return
652.	// for logout
653.	  const logout =()=>{
654.	    doLogout(()=>{
655.	      // logged out
656.	      setLogin(false)
657.	      navigate(“/”) ---- below one 
658.	    })
659.	  }
660.	…………….
661.	.in CustomNavbar= ()=>{
662.	// navigate to dashboard
663.	  let navigate = useNavigate()
664.	…………….
665.	. Call the function
666.	 <Nav navbar>
667.	            {/* logged In - we can see logout & username */}
668.	            {
669.	              // login comes from const [login
670.	              login && (
671.	                <>
672.	                <NavItem>
673.	              <NavLink onClick={logout}>
674.	                Logout
675.	              </NavLink>
676.	            </NavItem>
677.	            <NavItem>
678.	              <NavLink>
679.	                {/* // user comes from const [user */}
680.	                {user.email}
681.	              </NavLink>
682.	            </NavItem>
683.	                </>
684.	              )
685.	            }
686.	……………………………………………………………………………………………
687.	. Created a profile page.
688.	<Nav navbar>
689.	            {/* logged In - we can see logout & username */}
690.	            {
691.	              // login comes from const [login
692.	              login && (
693.	                <>
694.	                <NavItem>
695.	              <NavLink tag={ReactLink} to="/user/profile-info">
696.	                Profile Info
697.	              </NavLink>
698.	            </NavItem>
699.	                
700.	            <NavItem>
701.	              <NavLink tag={ReactLink} to="/user/dashboard">
702.	                {/* // user comes from const [user */}
703.	                {user.email}
704.	              </NavLink>
705.	            </NavItem>
706.	
707.	            <NavItem>
708.	              <NavLink onClick={logout}>
709.	                Logout
710.	              </NavLink>
711.	            </NavItem>
712.	                </>
713.	              )
714.	            }
715.	=================================================================================================
716.	..
717.	POST Form in React JS
718.	..
719.	. created a AddPost.jsx file in components folder.
720.	………..
721.	..and used in Userdashboard.jsx page .
722.	const Userdashboard=()=> {
723.	  return (
724.	    <Base>
725.	    <AddPost />
726.	    </Base>
727.	  )
728.	}
729.	export default Userdashboard
730.	…………..
731.	.
732.	.In AddPost.jsx created form for post.
733.	…..
734.	. in services folder created category-service.jsx file. It is a dropdown section in form.
735.	It will call API’s.
736.	import { myAxios } from "./helper"
737.	export const loadAllCategories =()=> {
738.	    return myAxios.get('/categories').then(response => {return response.data} )
739.	}
740.	………….
741.	.
742.	. used this category-service.js in AddPost.jsx file.
743.	// will get all categories from backend
744.	    useEffect(
745.	        ()=>{
746.	            loadAllCategories().then((data)=>{
747.	                console.log(data)
748.	            }).catch(error=>{
749.	                console.log(error)
750.	            })
751.	        },
752.	        []
753.	    )
754.	………………………………………………………………………………………………………………….
755.	.we can see on inspect(chrome/edge) only to reflect on page do next thing in AddPost.jsx
756.	………………………………………………………………………………………………………………….
757.	.
758.	import React, { useEffect, useState } from 'react'
759.	import { Button, Card, CardBody, Container, Form, Input, Label } from 'reactstrap'
760.	import { loadAllCategories } from '../services/category-service'
761.	
762.	const AddPost =()=> {
763.	
764.	    const [categories, setCategories] = useState([])
765.	
766.	    // will get all categories from backend
767.	    useEffect(
768.	        ()=>{
769.	            loadAllCategories().then((data)=>{
770.	                console.log(data)
771.	                setCategories(data)
772.	            }).catch(error=>{
773.	                console.log(error)
774.	            })
775.	        },
776.	        []
777.	    )
778.	
779.	  return (
780.	    <div className='wrapper'>
781.	        <Card className='shadow-sm border-0 mt-3'>
782.	            <CardBody>
783.	                <h3>Whats going in your mind ?</h3>
784.	                <Form>
785.	
786.	                    {/* title */}
787.	                    <div className='my-3'>
788.	                    <Label for='title'>Post title</Label>
789.	                    <Input type='text'
790.	                    id='title'
791.	                    placeholder='enter here'
792.	                    className='rounded-0' />
793.	                    </div>
794.	
795.	                    {/* content */}
796.	                    <div className='my-3'>
797.	                    <Label for='content'>Post Content</Label>
798.	                    <Input type='textarea'
799.	                    id='content'
800.	                    placeholder='enter here'
801.	                    className='rounded-0'
802.	                    style={{height:'200px'}} />
803.	                    </div>
804.	
805.	                    {/* content */}
806.	                    <div className='my-3'>
807.	                    <Label for='category'>Post Category</Label>
808.	                    <Input type='select'
809.	                    id='category'
810.	                    placeholder='enter here'
811.	                    className='rounded-0' >
812.	                          
813.	                          {/* write JavaScript here */}
814.	                          {
815.	                            categories.map((category)=>(
816.	                                <option value={category.categoryId} key={category.categoryId}>
817.	                                    {category.categoryTitle}
818.	                                </option>
819.	                            ))
820.	                          }
821.	
822.	                    </Input>
823.	                    </div>
824.	
825.	                    <Container className='text-center'>
826.	                        <Button className='rounded-0' color='primary'>Create Post</Button>
827.	                        <Button className='rounded-0 ms-2' color='danger'>Reset Content</Button>
828.	                    </Container>
829.	                </Form>
830.	            </CardBody>
831.	        </Card>
832.	    </div>
833.	  )
834.	}
835.	export default AddPost
836.	……………………………………………………………
837.	
838.	=================================================================================================
839.	.
840.	Text editor
841.	.search on chrome “jodit react”
842.	https://www.npmjs.com/package/jodit-react
843.	.
844.	.in VS - npm install jodit-react --save
845.	.
846.	.in AddPost.jsx
847.	// this is for rich text editor(Post content) 
848.	    const editor = useRef(null)
849.	    const [content, setContent] = useState('')
850.	const config={
851.	        placeholder:"start typing..."
852.	    }
853.	.
854.	In return(
855.	.             {/* content */}
856.	                    <div className='my-3'>
857.	                    <Label for='content'>Post Content</Label>
858.	
859.	                    {/* <Input type='textarea'
860.	                    id='content'
861.	                    placeholder='enter here'
862.	                    className='rounded-0'
863.	                    style={{height:'200px'}} /> */}
864.	
865.	                    <JoditEditor
866.	                    ref={editor}
867.	                    value={content}
868.	                    onChange={newContent => setContent(newContent)}
869.	                    />
870.	                    </div>
871.	.
872.	=================================================================================================
873.	.
874.	Completing Add Post Module
875.	.
876.	In addPost.jsx
877.	// for store data - to connect backend purpose
878.	    const [post, setPost]=useState({
879.	        title:'',
880.	        content:'',
881.	        categoryId:-1
882.	    })
883.	.
884.	. for binding purpose
885.	.in title 
886.	                      {/* title */}
887.	                    <div className='my-3'>
888.	                    <Label for='title'>Post title</Label>
889.	                    <Input type='text'
890.	                    id='title'
891.	                    placeholder='enter here'
892.	                    className='rounded-0' 
893.	                    name='title'
894.	                    onChange={fieldChanged}
895.	                    />
896.	                    </div>
897.	……
898.	Before return(
899.	. create fieldChanged function.
900.	  // create fieldChanged function.
901.	    const fieldChanged=(event)=>{
902.	        // console.log(event.target.name)
903.	        setPost({...post, 'title':event.target.value})
904.	    }
905.	……………………………………………..
906.	
907.	Same did for categoryId…
908.	name='categoryId'
909.	 onChange={fieldChanged} >
910.	….
911.	const fieldChanged=(event)=>{
912.	        // console.log(event.target.name)   -------------  for dynamic changes.
913.	        setPost({...post, [event.target.name]:event.target.value})
914.	    }
915.	.
916.	…………………………
917.	.
918.	For content
919.	.
920.	Create field before return{
921.	// to change content only (because we used jodit editor)
922.	    const contentFieldChanged=(data)=>{
923.	        setPost({...post,'content':data})
924.	    }
925.	..
926.	Add in content
927.	                                        {/* content */}
928.	                    <div className='my-3'>
929.	                    <Label for='content'>Post Content</Label>
930.	
931.	                    {/* <Input type='textarea'
932.	                    id='content'
933.	                    placeholder='enter here'
934.	                    className='rounded-0'
935.	                    style={{height:'200px'}} /> */}
936.	
937.	                    <JoditEditor
938.	                    ref={editor}
939.	                    // config={config}
940.	                    value={post.content}
941.	                    onChange={contentFieldChanged}
942.	                    />
943.	
944.	                    </div>……………………………………………………………………
945.	
946.	Button
947.	<Button type='submit' className='rounded-0' color='primary'>Create Post</Button>
948.	..
949.	.in form tag to submit form.
950.	<Form onSubmit={createPost}>
951.	..
952.	. // create createPost function
953.	    const createPost = (event) =>{
954.	        event.preventDefault();
955.	        console.log('form submitted')
956.	       console.log(post)
957.	    }
958.	……………
959.	.
960.	.for category
961.	.. {/* category */}
962.	                    <div className='my-3'>
963.	                    <Label for='category'>Post Category</Label>
964.	                    <Input type='select'
965.	                    id='category'
966.	                    placeholder='enter here'
967.	                    className='rounded-0' 
968.	                    name='categoryId'
969.	                    onChange={fieldChanged}
970.	                    defaultValue={0} >
971.	
972.	                        <option disabled value={0}>--select category--</option>
973.	                          
974.	                          {/* write JavaScript here */}
975.	                          {
976.	                            categories.map((category)=>(
977.	                                <option value={category.categoryId} key={category.categoryId}>
978.	                                    {category.categoryTitle}
979.	                                </option>
980.	                            ))
981.	                          }
982.	
983.	                    </Input>
984.	                    </div>
985.	…………….
986.	.
987.	. create post-service.js in services folder.
988.	
989.	import { myAxios } from "./helper"
990.	
991.	// create post function
992.	Export const createPost=(postData)=>{
993.	    return myAxios.post('/user/${postData.userId}/category/${postData.categoryId}/posts',postData).then(response=>response.data) ---URL
994.	}
995.	……
996.	.in AddPost.jsx
997.	. // used in "submit the form on server" 
998.	    const [user, setUser] = useState(undefined)
999.	.
1000.	useEffect(
1001.	        ()=>{
1002.	            // used for "to submit form on server" & get getCurrentUserDetail() from "index.jsx-auth"
1003.	            setUser(getCurrentUserDetail())
1004.	
1005.	            loadAllCategories().then((data)=>{
1006.	                console.log(data)
1007.	                setCategories(data)
1008.	            }).catch(error=>{
1009.	                console.log(error)
1010.	            })
1011.	        },
1012.	        []
1013.	    )
1014.	..
1015.	// submit the form on server
1016.	        post['userId'] = user.id
1017.	        doCreatePost(post).then(data=>{
1018.	            toast.success("Post Created !!")
1019.	            // console.log(post)
1020.	            setPost({
1021.	                title:'',
1022.	                content:'',
1023.	                categoryId:''
1024.	            })
1025.	        }).catch((error)=>{
1026.	            toast.error("Post not created due to some error !!")
1027.	            // console.log(error)
1028.	        })
1029.	.
1030.	………………………………………………………………….
1031.	For Token
1032.	…
1033.	In index.js
1034.	// will get token
1035.	export const getToken=()=>{
1036.	    if(isLoggedIn()){
1037.	        return JSON.parse(localStorage.getItem("data")).token
1038.	    }else{
1039.	        return null
1040.	    }
1041.	……………………………………….
1042.	In helper.js
1043.	.             // for token - used in AddPost.jsx
1044.	export const privateAxios = axios.create({
1045.	    baseURL:BASE_URL,
1046.	
1047.	    // /////////////////////////////////////////////////////////////////////////////
1048.	
1049.	    withCredentials: true,
1050.	    headers: {
1051.	        'Content-Type': 'application/json',
1052.	    
1053.	        Accept: 'application/json',
1054.	      },
1055.	
1056.	// //////////////////////////////////////////////////////////////////////////////////
1057.	
1058.	});
1059.	// will get token from index.js
1060.	privateAxios.interceptors.request.use((config)=>{
1061.	    const token = getToken();
1062.	    // console.log(token)
1063.	    if(token){
1064.	        // ----------------------user this-------back stick-
1065.	        // config.headers.common.Authorization= `Bearer ${token}`; 
1066.	        // -----------------------use this----------back stick------
1067.	        config.headers['Authorization'] = `Bearer ${token}`;
1068.	        // return config
1069.	        // console.log(config);
1070.	    }
1071.	    return config;
1072.	},
1073.	(error)=>Promise.reject(error)
1074.	);
1075.	……………….
1076.	.
1077.	.in post-service
1078.	. import { privateAxios } from "./helper"
1079.	
1080.	export const createPost=(postData)=>{
1081.	    // console.log(postData)
1082.	    // console.log('/user/${postData.userId}/category/${postData.categoryId}/posts');
1083.	    // back sticks - beacuse we used dynamic data in URL.
1084.	    return privateAxios.post(`/user/${postData.userId}/category/${postData.categoryId}/posts`,postData).then((response)=>response.data);
1085.	    // return privateAxios.post('/user/2/category/3/posts',postData).then((response)=>response.data);
1086.	
1087.	};
1088.	==========================================================================================
1089.	.
1090.	Creating new feed section
1091.	.
1092.	.created NewFeed.jsx in component folder. And used in Home.js
1093.	.
1094.	In Home.js
1095.	import { Container } from "reactstrap";
1096.	import Base from "../components/Base";
1097.	import NewFeed from "../components/NewFeed";
1098.	
1099.	const Home =()=>{
1100.	    return(
1101.	        <Base>
1102.	        <Container>
1103.	        <NewFeed />
1104.	        </Container>
1105.	        </Base>
1106.	    );
1107.	};
1108.	export default Home
1109.	……………………………….
1110.	
1111.	.in NewFeed.jsx.
1112.	import React, { useState } from 'react'
1113.	import { useEffect } from 'react'
1114.	import { loadAllPosts } from '../services/post-service'
1115.	import { Row,Col } from 'reactstrap'
1116.	import Post from './Post'
1117.	
1118.	function NewFeed() {
1119.	
1120.	    const [postContent,setPostContent]=useState({
1121.	        content:[]
1122.	    })
1123.	
1124.	    useEffect(()=>{
1125.	        // load all posts from the server
1126.	        loadAllPosts().then((data)=>{
1127.	            console.log(data)
1128.	            setPostContent(data)
1129.	        }).catch(error=>{
1130.	            console.log(error)
1131.	        })
1132.	    },[])
1133.	  return (
1134.	    
1135.	    <div className="container-fluid">
1136.	        <Row>
1137.	            <Col md={
1138.	                {
1139.	                    size:10,
1140.	                    offset:1
1141.	                }
1142.	            }>
1143.	                <h1>Blogs Count ({postContent?.totalElements}) </h1>
1144.	                
1145.	                {
1146.	                    postContent.content.map((post)=>(
1147.	                        <Post post={post} key={post.postId}/>
1148.	                    ))
1149.	                }
1150.	
1151.	            </Col>
1152.	        </Row>
1153.	    </div>
1154.	
1155.	  )
1156.	}
1157.	
1158.	export default NewFeed
1159.	.
1160.	……………………………………….
1161.	
1162.	In post-service.js
1163.	import { myAxios, privateAxios } from "./helper"
1164.	
1165.	// create post function
1166.	export const createPost=(postData)=>{
1167.	    // console.log(postData)
1168.	    // console.log('/user/${postData.userId}/category/${postData.categoryId}/posts');
1169.	    // back sticks - beacuse we used dynamic data in URL.
1170.	    return privateAxios.post(`/user/${postData.userId}/category/${postData.categoryId}/posts`,postData).then((response)=>response.data);
1171.	    // return privateAxios.post('/user/2/category/3/posts',postData).then((response)=>response.data);
1172.	};
1173.	
1174.	// get all post
1175.	export const loadAllPosts=()=>{
1176.	    return myAxios.get(`/posts`).then((response)=>response.data)
1177.	}
1178.	.
1179.	……………………………………………………..
1180.	.
1181.	Created Post.jsx in component folder
1182.	import React from 'react'
1183.	import { Button, Card, CardBody, CardText } from 'reactstrap'
1184.	
1185.	function Post({post={title:"this is default post title", content:"this is default post content"}}) {
1186.	  return (
1187.	    
1188.	    <Card className='border-0 shadow-sm mt-3'>
1189.	        <CardBody>
1190.	            <h1>{post.title}</h1>
1191.	            <CardText>
1192.	                {post.content.substring(0,50)}...
1193.	            </CardText>
1194.	            <div>
1195.	                <Button>Read More</Button>
1196.	            </div>
1197.	        </CardBody>
1198.	    </Card>
1199.	  )
1200.	}
1201.	
1202.	export default Post
1203.	.
1204.	==========================================================================================
1205.	.
1206.	Implementing Pagination with ReactJs
1207.	.
1208.	Search on chrome “reactstrap”.
1209.	. https://reactstrap.github.io/?path=/story/home-installation--page
1210.	.
1211.	.in NewFeed.js
1212.	. import React, { useState } from 'react'
1213.	import { useEffect } from 'react'
1214.	import { loadAllPosts } from '../services/post-service'
1215.	import { Row,Col, Pagination, PaginationItem, PaginationLink, Container } from 'reactstrap'
1216.	import Post from './Post'
1217.	import { toast } from 'react-toastify'
1218.	
1219.	function NewFeed() {
1220.	
1221.	    const [postContent,setPostContent]=useState({
1222.	        content:[],
1223.	        lastPage:false,
1224.	        pageNumber:'',
1225.	        pageSize:'',
1226.	        totalElements:'',
1227.	        totalPages:''
1228.	    })
1229.	
1230.	    useEffect(()=>{
1231.	        changePage(0)
1232.	    },[])
1233.	
1234.	    // for pagination 
1235.	    const changePage=(pageNumber=0, pageSize=5)=>{
1236.	        
1237.	        loadAllPosts(pageNumber, pageSize).then((data)=>{
1238.	            setPostContent(data)
1239.	            window.scroll(0,0)
1240.	        }).catch(error=>{
1241.	            toast.error("Error in loading post !!")
1242.	        })
1243.	    }
1244.	
1245.	  return (
1246.	    
1247.	    <div className="container-fluid">
1248.	        <Row>
1249.	            <Col md={
1250.	                {
1251.	                    size:10,
1252.	                    offset:1
1253.	                }
1254.	            }>
1255.	                <h1>Blogs Count ({postContent?.totalElements}) </h1>
1256.	                
1257.	                {
1258.	                    postContent.content.map((post)=>(
1259.	                        <Post post={post} key={post.postId}/>
1260.	                    ))
1261.	                }
1262.	
1263.	                {/* pagination from reactstrap */}
1264.	
1265.	                <Container className='mt-3'>
1266.	
1267.	                <Pagination size='lg' >
1268.	
1269.	                    <PaginationItem onClick={() => changePage(--postContent.pageNumber)} disabled={postContent.pageNumber===0}>
1270.	                            <PaginationLink previous>
1271.	                                Previous
1272.	                            </PaginationLink>
1273.	                    </PaginationItem>
1274.	
1275.	                        {
1276.	                            [...Array(postContent.totalPages)].map((item, index)=>(
1277.	                                <PaginationItem onClick={() =>changePage(index)} active={index===postContent.pageNumber} key={index}>
1278.	                            <PaginationLink>
1279.	                                {index+1}
1280.	                            </PaginationLink>
1281.	                        </PaginationItem>
1282.	                            ))
1283.	                        }
1284.	
1285.	                        <PaginationItem onClick={()=>changePage(++postContent.pageNumber)} disabled={postContent.lastPage}>
1286.	                            <PaginationLink next>
1287.	                                Next
1288.	                            </PaginationLink>
1289.	                        </PaginationItem>
1290.	
1291.	                    </Pagination>
1292.	
1293.	                </Container>
1294.	
1295.	            </Col>
1296.	        </Row>
1297.	    </div>
1298.	
1299.	  )
1300.	}
1301.	
1302.	export default NewFeed
1303.	………………………….
1304.	In post-service.js
1305.	.
1306.	. import { myAxios, privateAxios } from "./helper"
1307.	
1308.	// create post function
1309.	export const createPost=(postData)=>{
1310.	    // console.log(postData)
1311.	    // console.log('/user/${postData.userId}/category/${postData.categoryId}/posts');
1312.	    // back sticks - beacuse we used dynamic data in URL.
1313.	    return privateAxios.post(`/user/${postData.userId}/category/${postData.categoryId}/posts`,postData).then((response)=>response.data);
1314.	    // return privateAxios.post('/user/2/category/3/posts',postData).then((response)=>response.data);
1315.	};
1316.	
1317.	// get all post
1318.	export const loadAllPosts=(pageNumber, pageSize)=>{
1319.	    return myAxios.get(`/posts?pageNumber=${pageNumber}&pageSize=${pageSize}`).then((response)=>response.data)
1320.	}
1321.	……………………………….
1322.	.
1323.	.in App.css
1324.	.. body{
1325.	    background: #eceff1!important;
1326.	}
1327.	
1328.	.active>.page-link, .page-link.active{
1329.	    background-color: #121212!important;
1330.	    border-color:  #121212!important;
1331.	}
1332.	.
1333.	==========================================================================================
1334.	.
1335.	Fixing pagination problem
1336.	.
1337.	in NewFeed.js
1338.	.
1339.	. import React, { useState } from 'react'
1340.	import { useEffect } from 'react'
1341.	import { loadAllPosts } from '../services/post-service'
1342.	import { Row,Col, Pagination, PaginationItem, PaginationLink, Container } from 'reactstrap'
1343.	import Post from './Post'
1344.	import { toast } from 'react-toastify'
1345.	
1346.	function NewFeed() {
1347.	
1348.	    const [postContent,setPostContent]=useState({
1349.	        content:[],
1350.	        lastPage:false,
1351.	        pageNumber:'',
1352.	        pageSize:'',
1353.	        totalElements:'',
1354.	        totalPages:''
1355.	    })
1356.	
1357.	    useEffect(()=>{
1358.	        changePage(0)
1359.	    },[])
1360.	
1361.	    // for pagination 
1362.	    const changePage=(pageNumber=0, pageSize=5)=>{
1363.	
1364.	        // for pagination increment and decrement
1365.	        if(pageNumber>postContent.pageNumber && postContent.lastPage){
1366.	            return
1367.	        }
1368.	        if(pageNumber<postContent.pageNumber && postContent.pageNumber==0){
1369.	            return
1370.	        }
1371.	        
1372.	        loadAllPosts(pageNumber, pageSize).then((data)=>{
1373.	            setPostContent(data)
1374.	            window.scroll(0,0)
1375.	        }).catch(error=>{
1376.	            toast.error("Error in loading post !!")
1377.	        })
1378.	    }
1379.	
1380.	  return (
1381.	    
1382.	    <div className="container-fluid">
1383.	        <Row>
1384.	            <Col md={
1385.	                {
1386.	                    size:10,
1387.	                    offset:1
1388.	                }
1389.	            }>
1390.	                <h1>Blogs Count ({postContent?.totalElements}) </h1>
1391.	                
1392.	                {
1393.	                    postContent.content.map((post)=>(
1394.	                        <Post post={post} key={post.postId}/>
1395.	                    ))
1396.	                }
1397.	
1398.	                {/* pagination from reactstrap */}
1399.	
1400.	                <Container className='mt-3'>
1401.	
1402.	                <Pagination size='lg' >
1403.	
1404.	                    <PaginationItem onClick={() => changePage(postContent.pageNumber-1)} disabled={postContent.pageNumber===0}>
1405.	                            <PaginationLink previous>
1406.	                                Previous
1407.	                            </PaginationLink>
1408.	                    </PaginationItem>
1409.	
1410.	                        {
1411.	                            [...Array(postContent.totalPages)].map((item, index)=>(
1412.	                                <PaginationItem onClick={() =>changePage(index)} active={index===postContent.pageNumber} key={index}>
1413.	                            <PaginationLink>
1414.	                                {index+1}
1415.	                            </PaginationLink>
1416.	                        </PaginationItem>
1417.	                            ))
1418.	                        }
1419.	
1420.	                        <PaginationItem onClick={()=>changePage(postContent.pageNumber+1)} disabled={postContent.lastPage}>
1421.	                            <PaginationLink next>
1422.	                                Next
1423.	                            </PaginationLink>
1424.	                        </PaginationItem>
1425.	
1426.	                    </Pagination>
1427.	
1428.	                </Container>
1429.	
1430.	            </Col>
1431.	        </Row>
1432.	    </div>
1433.	
1434.	  )
1435.	}
1436.	
1437.	export default NewFeed
1438.	………………………………..
1439.	.
1440.	In Post.jsx
1441.	..
1442.	import React from 'react'
1443.	import { Button, Card, CardBody, CardText } from 'reactstrap'
1444.	
1445.	function Post({post={title:"this is default post title", content:"this is default post content"}}) {
1446.	  return (
1447.	    
1448.	    <Card className='border-0 shadow-sm mt-3'>
1449.	        <CardBody>
1450.	            <h1>{post.title}</h1>
1451.	---------------- convert HTML  to simple text
1452.	            <CardText dangerouslySetInnerHTML={{__html:post.content.substring(0,50)+"....."}}>
1453.	            </CardText>
1454.	            <div>
1455.	                <Button>Read More</Button>
1456.	            </div>
1457.	        </CardBody>
1458.	    </Card>
1459.	  )
1460.	}
1461.	
1462.	export default Post
1463.	.
1464.	==========================================================================================
1465.	.
1466.	Completing BLOG Post page
1467.	.
1468.	Created PostPage.jsx in Pages folder……………………………………………………
1469.	import { Link, useParams } from "react-router-dom"
1470.	import Base from "../components/Base"
1471.	import { useEffect, useState } from "react"
1472.	import { loadPost } from "../services/post-service"
1473.	import { toast } from "react-toastify"
1474.	import { Card, CardBody, CardText, Col, Container, Row } from "reactstrap"
1475.	import { BASE_URL } from "../services/helper"
1476.	
1477.	const PostPage =()=>{
1478.	
1479.	    const {postId}=useParams()
1480.	    const[post, setPost]=useState(null)
1481.	
1482.	    useEffect(()=>{
1483.	        // load post of PostId
1484.	        loadPost(postId).then(data=>{
1485.	            console.log(data);
1486.	            setPost(data)
1487.	        }).catch(error=>{
1488.	            console.log(error)
1489.	            toast.error("error in loading post !!")
1490.	        })
1491.	    },[])
1492.	
1493.	    const printDate=(numbers)=>{
1494.	        return new Date(numbers).toLocaleDateString()
1495.	    }
1496.	
1497.	    return (
1498.	        <Base>
1499.	        <Container className='mt-4'>
1500.	
1501.	            <Link to="/">Home</Link> / {post && (<Link to=''>{post.title}</Link>)}
1502.	            <Row>
1503.	            <Col md={{
1504.	                size:12
1505.	            }}>
1506.	
1507.	                <Card className="mt-3 ps-2 border-0 shadow-sm">
1508.	                    {
1509.	                        (post)&&(
1510.	                            <CardBody>
1511.	                            <CardText>Posted by <b>{post.user.name}</b> on <b>{printDate(post.addedDate)}</b> </CardText>
1512.	                            <CardText><span className="text-muted">{post.category.categoryTitle}</span></CardText>
1513.	                            <div className="divider" style={{
1514.	                                width:'100%',
1515.	                                height:'1px',
1516.	                                background:'#e2e2e2'
1517.	                            }}></div>
1518.	                            <CardText className="mt-3"><h1>{post.title}</h1></CardText>
1519.	                            <div className="image-container mt-4 shadow" style={{maxWidth:'50%'}}>
1520.	                                <img className="img-fluid" src={BASE_URL+'/post/image/'+post.imageName} alt="" />
1521.	                            </div>
1522.	                            <CardText className="mt-5" dangerouslySetInnerHTML={{__html:post.content}}></CardText>
1523.	                        </CardBody>
1524.	                        )
1525.	                    }
1526.	                </Card> 
1527.	
1528.	            </Col>
1529.	            </Row>
1530.	            
1531.	        </Container>
1532.	        </Base>
1533.	    )
1534.	}
1535.	export default PostPage
1536.	…………………………………………………………………………………………………
1537.	.
1538.	Added route in App.js
1539.	<Route path="/posts/:postId" element={<PostPage/>}/>
1540.	……………
1541.	In Post.jsx…………………………..
1542.	import React from 'react'
1543.	import { Link } from 'react-router-dom'
1544.	import { Button, Card, CardBody, CardText } from 'reactstrap'
1545.	
1546.	function Post({post={title:"this is default post title", content:"this is default post content"}}) {
1547.	  return (
1548.	    
1549.	    <Card className='border-0 shadow-sm mt-3'>
1550.	        <CardBody>
1551.	            <h1>{post.title}</h1>
1552.	            {/* convert HTML to simple text */}
1553.	            <CardText dangerouslySetInnerHTML={{__html:post.content.substring(0,50)+"....."}}>
1554.	            </CardText>
1555.	            <div>
1556.	                <Link className='btn btn-secondary border-0' to={'/posts/'+post.postId}>Read More</Link>
1557.	            </div>
1558.	        </CardBody>
1559.	    </Card> 
1560.	  )
1561.	}
1562.	
1563.	export default Post
1564.	………………………………………….
1565.	In post-service.js
1566.	// get all post
1567.	export const loadAllPosts=(pageNumber, pageSize)=>{
1568.	    return myAxios
1569.	.get(`/posts?pageNumber=${pageNumber}&pageSize=${pageSize}&sortBy=addedDate&sortDir=desc`).then((response)=>response.data)
1570.	}
1571.	
1572.	// load single post of given id
1573.	export const loadPost=(postId)=>{
1574.	    return myAxios.get("/posts/"+postId).then((response)=>response.data)
1575.	}
1576.	………………………………………………
1577.	==========================================================================================
1578.	.
1579.	Building comment section
1580.	.
1581.	In PostPage.jsx
1582.	import { Link, useParams } from "react-router-dom"
1583.	import Base from "../components/Base"
1584.	import { useEffect, useState } from "react"
1585.	import { createComment, loadPost } from "../services/post-service"
1586.	import { toast } from "react-toastify"
1587.	import { Button, Card, CardBody, CardText, Col, Container, Input, Row } from "reactstrap"
1588.	import { BASE_URL } from "../services/helper"
1589.	import { isLoggedIn } from "../auth"
1590.	
1591.	const PostPage =()=>{
1592.	
1593.	    const {postId}=useParams()
1594.	    const[post, setPost]=useState(null)
1595.	
1596.	    // variable for set comment
1597.	    // content same as used in backend
1598.	    const[comment, setComment]=useState({
1599.	        content:''
1600.	    })
1601.	
1602.	    useEffect(()=>{
1603.	        // load post of PostId
1604.	        loadPost(postId).then(data=>{
1605.	            console.log(data);
1606.	            setPost(data)
1607.	        }).catch(error=>{
1608.	            console.log(error)
1609.	            toast.error("error in loading post !!")
1610.	        })
1611.	    },[])
1612.	
1613.	    const printDate=(numbers)=>{
1614.	        return new Date(numbers).toLocaleDateString()
1615.	    }
1616.	
1617.	    const  submitPost=()=>{
1618.	        // if user is login then only he/she can give comment
1619.	        if(!isLoggedIn()){
1620.	            toast.error("need to login first !!")
1621.	            return
1622.	        }
1623.	        if(comment.content.trim()===""){
1624.	            return
1625.	        }
1626.	        createComment(comment,post.postId)
1627.	        .then(data=>{
1628.	            console.log(data)
1629.	            toast.success("comment added..")
1630.	            setPost({
1631.	                ...post,
1632.	                comments:[...post.comments, data.data]
1633.	            })
1634.	            setComment({
1635.	                content:""
1636.	            })
1637.	        }).catch(error=>{
1638.	            console.log(error)
1639.	        })
1640.	    }
1641.	
1642.	    return (
1643.	        <Base>
1644.	        <Container className='mt-4'>
1645.	
1646.	            <Link to="/">Home</Link> / {post && (<Link to=''>{post.title}</Link>)}
1647.	            <Row>
1648.	            <Col md={{
1649.	                size:12
1650.	            }}>
1651.	
1652.	                <Card className="mt-3 ps-2 border-0 shadow-sm">
1653.	                    {
1654.	                        (post)&&(
1655.	                            <CardBody>
1656.	                            <CardText>Posted by <b>{post.user.name}</b> on <b>{printDate(post.addedDate)}</b> </CardText>
1657.	                            <CardText><span className="text-muted">{post.category.categoryTitle}</span></CardText>
1658.	                            <div className="divider" style={{
1659.	                                width:'100%',
1660.	                                height:'1px',
1661.	                                background:'#e2e2e2'
1662.	                            }}></div>
1663.	                            <CardText className="mt-3"><h1>{post.title}</h1></CardText>
1664.	                            <div className="image-container mt-4 shadow" style={{maxWidth:'50%'}}>
1665.	                                <img className="img-fluid" src={BASE_URL+'/post/image/'+post.imageName} alt="" />
1666.	                            </div>
1667.	                            <CardText className="mt-5" dangerouslySetInnerHTML={{__html:post.content}}></CardText>
1668.	                        </CardBody>
1669.	                        )
1670.	                    }
1671.	                </Card> 
1672.	
1673.	            </Col>
1674.	            </Row>
1675.	            {/* -----------------------for comments----------------------- */}
1676.	            <Row className="my-4">
1677.	                <Col md={
1678.	                    {
1679.	                        size:9,
1680.	                        offset:1
1681.	                    }
1682.	                }>
1683.	                <h3>Comments ({post ? post.comments.length : 0}) </h3>
1684.	                {
1685.	                    post && post.comments.map((c,index)=>(
1686.	                        <Card className="mt-2 border-0" key={index}>
1687.	                        <CardBody>
1688.	                            <CardText>
1689.	                                {c.content}
1690.	                            </CardText>
1691.	                        </CardBody>
1692.	                    </Card>
1693.	                    ))
1694.	                }
1695.	
1696.	                {/* --------------------------new comment------------------------ */}
1697.	                <Card className="mt-2 border-0">
1698.	                        <CardBody>
1699.	                            <CardText>
1700.	                                <Input type="textarea" 
1701.	                                placeholder="Enter comment here"
1702.	                                // this {comment comes from varibale}
1703.	                                value={comment.content}
1704.	                                onChange={(event)=>setComment({content:event.target.value})}
1705.	                                />
1706.	                                <Button onClick={submitPost} className="mt-2" color="primary">Submit</Button>
1707.	                            </CardText>
1708.	                        </CardBody>
1709.	                    </Card>
1710.	                </Col>
1711.	
1712.	            </Row>
1713.	        </Container>
1714.	        </Base>
1715.	    )
1716.	}
1717.	export default PostPage
1718.	.
1719.	…………………………………………………………………………………………………………………
1720.	In post-service.js
1721.	// for new comment 
1722.	export const createComment=(comment, postId)=>{
1723.	    return privateAxios.post(`/post/${postId}/comments`,comment)
1724.	}
1725.	..
1726.	==========================================================================================
1727.	.
1728.	Implementing Infinite scroll
1729.	.
1730.	search on chrome – “infinite scroll react js”
1731.	open npm site - https://www.npmjs.com/package/react-infinite-scroll-component
1732.	npm install --save react-infinite-scroll-component
1733.	.
1734.	----------------------------- Code ---------------------------------------------------------------------------------------
1735.	In NewFeed.jsx
1736.	import React, { useState } from 'react'
1737.	import { useEffect } from 'react'
1738.	import { loadAllPosts } from '../services/post-service'
1739.	import { Row, Col } from 'reactstrap'
1740.	// import { Row, Col, Pagination, PaginationItem, PaginationLink, Container } from 'reactstrap'
1741.	import Post from './Post'
1742.	import { toast } from 'react-toastify'
1743.	import InfiniteScroll from 'react-infinite-scroll-component'
1744.	
1745.	function NewFeed() {
1746.	
1747.	    const [postContent, setPostContent] = useState({
1748.	        content: [],
1749.	        lastPage: false,
1750.	        pageNumber: '',
1751.	        pageSize: '',
1752.	        totalElements: '',
1753.	        totalPages: ''
1754.	    })
1755.	
1756.	    // for infinite scroll -------------------------
1757.	    const [currentPage, setCurrentPage] = useState(0)
1758.	
1759.	    useEffect(() => {
1760.	        changePage(currentPage)
1761.	    }, [currentPage])
1762.	
1763.	    // for pagination 
1764.	    const changePage = (pageNumber = 0, pageSize = 5) => {
1765.	
1766.	        // for pagination increment and decrement
1767.	        if (pageNumber > postContent.pageNumber && postContent.lastPage) {
1768.	            return
1769.	        }
1770.	        if (pageNumber < postContent.pageNumber && postContent.pageNumber === 0) {
1771.	            return
1772.	        }
1773.	
1774.	        loadAllPosts(pageNumber, pageSize).then((data) => {
1775.	            setPostContent({
1776.	                content: [...postContent.content, ...data.content],
1777.	                lastPage: data.lastPage,
1778.	                pageNumber: data.pageNumber,
1779.	                pageSize: data.pageSize,
1780.	                totalElements: data.totalElements,
1781.	                totalPages: data.totalPages
1782.	            })
1783.	            console.log(data)
1784.	            // window.scroll(0, 0)
1785.	        }).catch(error => {
1786.	            toast.error("Error in loading post !!")
1787.	        })
1788.	    }
1789.	
1790.	    // Infinite scroll -------------
1791.	    const changePageInfinite = () => {
1792.	        console.log("page changed")
1793.	        setCurrentPage(currentPage + 1)
1794.	    }
1795.	    // ----------------------------
1796.	
1797.	    return (
1798.	
1799.	        <div className="container-fluid">
1800.	            <Row>
1801.	                <Col md={
1802.	                    {
1803.	                        size: 10,
1804.	                        offset: 1
1805.	                    }
1806.	                }>
1807.	                    <h1>Blogs Count ({postContent?.totalElements}) </h1>
1808.	
1809.	                    {/* ---------Infinite scroll-------- */}
1810.	                    <InfiniteScroll
1811.	                        dataLength={postContent.content.length}
1812.	                        next={changePageInfinite}
1813.	                        hasMore={!postContent.lastPage}
1814.	                        loader={<h4>Loading...</h4>}
1815.	                        endMessage={
1816.	                            <p style={{ textAlign: 'center' }}>
1817.	                                <b>Yay! You have seen it all</b>
1818.	                            </p>
1819.	                        }
1820.	                    >
1821.	                        {
1822.	                            postContent.content.map((post) => (
1823.	                                <Post post={post} key={post.postId} />
1824.	                            ))
1825.	                        }
1826.	                    </InfiniteScroll>
1827.	                </Col>
1828.	            </Row>
1829.	        </div>
1830.	
1831.	    )
1832.	}
1833.	
1834.	export default NewFeed
1835.	----------------------------- Code End---------------------------------------------------------------------------------------
1836.	==========================================================================================
1837.	.
1838.	.
1839.	Context API -useContext Hook
1840.	.
1841.	Contexts provide a way to pass data through the component tree without having to pass props down manually at every level.
1842.	.
1843.	We can use props to send data from one component to another, but it is complicated that why we use Context.
1844.	.
1845.	Steps to create Context API (3 steps)
1846.	1- create Context
1847.	– context=createContext(null)
1848.	– provider
1849.	- consumer
1850.	2- wrap our components in provider
1851.	<context. Provider value={user}>
1852.	              children
1853.	</context. Provider>
1854.	3- consume the value with the help of consumer
1855.	<context. Consumer>
1856.	       {
1857.	            (value)=>(<div>
1858.	                                     {value.name}
1859.	                              </div>)
1860.	        }
1861.	</context. Consumer>
1862.	………………………………………………………………………………………….
1863.	.
1864.	- Create a folder in src named “context”.
1865.	- Create a userContext.js file in context folder.
i.	import { createContext } from "react";
ii.	
iii.	const userContext = createContext(null)
iv.	export default userContext
1866.	– create a file UserProvider.jsx in context folder. (userContext.Provider)
i.	import React, { Children, useState } from 'react'
ii.	import userContext from './userContext'
iii.	
iv.	function UserProvider({Children}) {
v.	    const [user, setUser] = useState({
vi.	        name:'akshay shewale'
vii.	    })
viii.	  return (
ix.	    <userContext.Provider value={user}>
x.	        {Children}
xi.	    </userContext.Provider>
xii.	  )
xiii.	}
xiv.	
xv.	export default UserProvider
1867.	– add UserProviser tag in App.js file above all routes.
1868.	– and use in any component (userContext.Consumer)
1869.	In About.jsx
i.	import Base from "../components/Base";
ii.	import userContext from "../context/userContext";
iii.	
iv.	const About =()=> {
v.	    return(
vi.	       <userContext.Consumer>
vii.	        {
viii.	            (user)=>(
ix.	                <Base>
x.	                <h1>this is about page</h1>
xi.	                <p>we are building blog app</p>
xii.	                <h1>Welcome user : {user.name}</h1>
xiii.	                </Base>
xiv.	            )
xv.	        }
xvi.	       </userContext.Consumer>
xvii.	    )
xviii.	};
xix.	
xx.	export default About;
1870.	.
1871.	……….. another way – use in any component (userContext.Consumer) ………………………..
1872.	Use useContext HOOK.
1873.	
i.	import React, { useContext } from 'react'
ii.	import Base from '../../components/Base'
iii.	import userContext from '../../context/userContext'
iv.	
v.	const ProfileInfo =()=> {
vi.	  const user = useContext(userContext)
vii.	  return (
viii.	    <Base>
ix.	    <div>ProfileInfo</div>
x.	    <h1>welcome user : {user.name}</h1>
xi.	    </Base>
xii.	  )
xiii.	}
xiv.	
xv.	export default ProfileInfo
1874.	
1875.	==========================================================================================
1876.	.
1877.	Image uploading module.
1878.	.
1879.	In AddPost.jsx
1880.	import React, { useEffect, useRef, useState } from 'react'
1881.	import { Button, Card, CardBody, Container, Form, Input, Label } from 'reactstrap'
1882.	import { loadAllCategories } from '../services/category-service'
1883.	import JoditEditor from 'jodit-react'
1884.	import { createPost as doCreatePost, uploadPostImage } from '../services/post-service'
1885.	import { getCurrentUserDetail } from '../auth'
1886.	import { toast } from 'react-toastify'
1887.	
1888.	const AddPost = () => {
1889.	
1890.	    // this is for rich text editor(Post content) 
1891.	    const editor = useRef(null)
1892.	
1893.	    // content - to solve issue use memo
1894.	    // const config={
1895.	    //     placeholder:"start typing..."
1896.	    // }
1897.	
1898.	    const [categories, setCategories] = useState([])
1899.	
1900.	    // used in "submit the form on server" 
1901.	    const [user, setUser] = useState(undefined)
1902.	
1903.	    // for store data - to connect backend purpose
1904.	    const [post, setPost] = useState({
1905.	        title: '',
1906.	        content: '',
1907.	        categoryId: ''
1908.	    })
1909.	
1910.	    // for to upload image
1911.	    const [image, setImage] = useState(null)
1912.	
1913.	    // will get all categories from backend
1914.	    useEffect(
1915.	        () => {
1916.	            // used for "to submit form on server" & get getCurrentUserDetail() from "index.jsx-auth"
1917.	            setUser(getCurrentUserDetail())
1918.	
1919.	            loadAllCategories().then((data) => {
1920.	                console.log(data)
1921.	                setCategories(data)
1922.	            }).catch(error => {
1923.	                console.log(error)
1924.	            })
1925.	        },
1926.	        []
1927.	    )
1928.	
1929.	    // create fieldChanged function.
1930.	    const fieldChanged = (event) => {
1931.	        // console.log(event.target.name)
1932.	        setPost({ ...post, [event.target.name]: event.target.value })
1933.	    }
1934.	
1935.	    // to change content only (because we used jodit editor)
1936.	    const contentFieldChanged = (data) => {
1937.	        setPost({ ...post, 'content': data })
1938.	    }
1939.	
1940.	    // create createPost function
1941.	    const createPost = (event) => {
1942.	        event.preventDefault();
1943.	        // console.log("form submitted")
1944.	        // console.log(post)
1945.	
1946.	        if (post.title.trim() === '') {
1947.	            toast.error('post title is required !! ')
1948.	            return
1949.	        }
1950.	
1951.	        if (post.content.trim() === '') {
1952.	            toast.error('post content is required !! ')
1953.	            return
1954.	        }
1955.	
1956.	        if (post.categoryId === '') {
1957.	            toast.error('select some category !! ')
1958.	            return
1959.	        }
1960.	
1961.	        // submit the form on server
1962.	        post['userId'] = user.id
1963.	        doCreatePost(post).then(data => {
1964.	            // ---------to upload image---------
1965.	            uploadPostImage(image,data.postId).then(data=>{
1966.	                toast.success("image upload !!")
1967.	            }).catch(error=>{
1968.	                toast.error("Error in uploading image")
1969.	                console.log(error)
1970.	            })
1971.	            // -----------------
1972.	            toast.success("Post Created !!")
1973.	            // console.log(post)
1974.	            setPost({
1975.	                title: '',
1976.	                content: '',
1977.	                categoryId: ''
1978.	            })
1979.	        }).catch((error) => {
1980.	            toast.error("Post not created due to some error !!")
1981.	             console.log(error)
1982.	        })
1983.	
1984.	
1985.	    }
1986.	
1987.	    // handling file/image change event
1988.	
1989.	    const handleFileChange = (event) => {
1990.	        console.log(event.target.files[0])
1991.	        setImage(event.target.files[0])
1992.	    }
1993.	
1994.	    return (
1995.	        <div className='wrapper'>
1996.	            <Card className='shadow-sm border-0 mt-3'>
1997.	                <CardBody>
1998.	
1999.	                    {/* using this we can ses output on form only post content*/}
2000.	                    {/* {JSON.stringify(post)} */}
2001.	
2002.	                    <h3>Whats going in your mind ?</h3>
2003.	                    <Form onSubmit={createPost}>
2004.	
2005.	                        {/* title */}
2006.	                        <div className='my-3'>
2007.	                            <Label for='title'>Post title</Label>
2008.	                            <Input type='text'
2009.	                                id='title'
2010.	                                placeholder='enter here'
2011.	                                className='rounded-0'
2012.	                                name='title'
2013.	                                onChange={fieldChanged}
2014.	                            />
2015.	                        </div>
2016.	
2017.	                        {/* content */}
2018.	                        <div className='my-3'>
2019.	                            <Label for='content'>Post Content</Label>
2020.	
2021.	                            {/* <Input type='textarea'
2022.	                    id='content'
2023.	                    placeholder='enter here'
2024.	                    className='rounded-0'
2025.	                    style={{height:'200px'}} /> */}
2026.	
2027.	                            <JoditEditor
2028.	                                ref={editor}
2029.	                                // config={config}
2030.	                                value={post.content}
2031.	                                onChange={contentFieldChanged}
2032.	                            />
2033.	
2034.	                        </div>
2035.	
2036.	                        {/* upload image/file field */}
2037.	                        <div className="mt-3">
2038.	                            <Label for='image'>Select Post Image</Label>
2039.	                            <Input id='image' type='file' onChange={handleFileChange} />
2040.	                        </div>
2041.	
2042.	                        {/* category */}
2043.	                        <div className='my-3'>
2044.	                            <Label for='category'>Post Category</Label>
2045.	                            <Input type='select'
2046.	                                id='category'
2047.	                                placeholder='enter here'
2048.	                                className='rounded-0'
2049.	                                name='categoryId'
2050.	                                onChange={fieldChanged}
2051.	                                defaultValue={0} >
2052.	
2053.	                                <option disabled value={0}>--select category--</option>
2054.	
2055.	                                {/* write JavaScript here */}
2056.	                                {
2057.	                                    categories.map((category) => (
2058.	                                        <option value={category.categoryId} key={category.categoryId}>
2059.	                                            {category.categoryTitle}
2060.	                                        </option>
2061.	                                    ))
2062.	                                }
2063.	
2064.	                            </Input>
2065.	                        </div>
2066.	
2067.	                        <Container className='text-center'>
2068.	                            <Button type='submit' className='rounded-0' color='primary'>Create Post</Button>
2069.	                            <Button className='rounded-0 ms-2' color='danger'>Reset Content</Button>
2070.	                        </Container>
2071.	                    </Form>
2072.	                </CardBody>
2073.	            </Card>
2074.	        </div>
2075.	    )
2076.	}
2077.	export default AddPost
2078.	……………………………………………………………
2079.	.
2080.	In Post-service.js – add this piece of code.
2081.	// upload image/file 
2082.	export const uploadPostImage =(image,postId)=>{
2083.	    let formData = new FormData()
2084.	    formData.append("image",image)
2085.	    return privateAxios.post(`/post/image/upload/${postId}`,formData,{
2086.	        headers:{
2087.	            'Content-Type':'multipart/form-data'
2088.	        }
2089.	    }).then((response)=>response.data)
2090.	}
2091.	.
2092.	==========================================================================================
2093.	.
2094.	Filtering Blogs category wise
2095.	.
2096.	Created new component CategorySideMenu.jsx. 
2097.	.
2098.	import React, { useEffect, useState } from 'react'
2099.	import { ListGroup, ListGroupItem } from 'reactstrap'
2100.	import { loadAllCategories } from '../services/category-service'
2101.	import { toast } from 'react-toastify'
2102.	import { Link } from 'react-router-dom'
2103.	
2104.	function CategorySideMenu() {
2105.	  const [categories, setCategories] = useState([])
2106.	  useEffect(()=>{
2107.	    loadAllCategories().then(data=>{
2108.	      console.log(data)
2109.	      setCategories([...data])
2110.	    }).catch(error=>{
2111.	      console.log(error)
2112.	      toast.error("error in loading categories")
2113.	    })
2114.	  },[])
2115.	  return (
2116.	    <div>
2117.	        <ListGroup>
2118.	            <ListGroupItem tag={Link} to='/' action={true} className='border-0'>
2119.	                All Blogs
2120.	            </ListGroupItem>
2121.	            {categories && categories.map((cat,index)=>{
2122.	              return(
2123.	                <ListGroupItem tag={Link} to={'/categories/'+cat.categoryId} className='border-0 shadow-0 mt-1' key={index} action={true}>
2124.	                  {cat.categoryTitle}
2125.	                </ListGroupItem>
2126.	              )
2127.	            })}
2128.	        </ListGroup>
2129.	    </div>
2130.	  )
2131.	}
2132.	
2133.	export default CategorySideMenu
2134.	………………………………………………………………………….
2135.	.
2136.	Created new File in pages named as Categories.jsx.
2137.	
2138.	import React, { useEffect, useState } from 'react'
2139.	import Base from '../components/Base'
2140.	import { useParams } from 'react-router-dom'
2141.	import { Col, Container, Row } from "reactstrap";
2142.	// import NewFeed from "../components/NewFeed";
2143.	import CategorySideMenu from "../components/CategorySideMenu";
2144.	import { loadPostCategoryWise } from '../services/post-service';
2145.	import { toast } from 'react-toastify';
2146.	import Post from '../components/Post';
2147.	
2148.	function Categories() {
2149.	    const [posts, setPosts] = useState([])
2150.	    // we are using useParams to fetch category
2151.	    const {categoryId} = useParams()
2152.	    useEffect(()=>{
2153.	        console.log(categoryId)
2154.	        loadPostCategoryWise(categoryId).then(data=>{
2155.	            setPosts([...data])
2156.	        }).catch(error=>{
2157.	            console.log(error)
2158.	            toast.error("error in loading posts")
2159.	        })
2160.	    }, [categoryId])
2161.	  return (
2162.	    <Base>
2163.	    <Container className="mt-3">
2164.	        <Row>
2165.	          <Col md={2} className="pt-5">
2166.	            <CategorySideMenu />
2167.	          </Col>
2168.	          <Col md={10}>
2169.	            <h1>Blogs Count ({posts.length})</h1>
2170.	            {
2171.	                posts && posts.map((post,index)=>{
2172.	                    return(
2173.	                        <Post key={index} post = {post}/>
2174.	                    )
2175.	                })
2176.	            }
2177.	            {posts.length<=0? <h1>No post in this category</h1> : ''}
2178.	          </Col>
2179.	        </Row>
2180.	      </Container>
2181.	    </Base>
2182.	  )
2183.	}
2184.	
2185.	export default Categories
2186.	………………………………………………………………………………………………..
2187.	.
2188.	In post-service.js
2189.	.
2190.	// get category wise post
2191.	export const loadPostCategoryWise=(categoryId)=>{
2192.	    return privateAxios.get(`/category/${categoryId}/posts`).then((res)=>res.data)
2193.	}
2194.	.
2195.	…………………………………………………………………………………………………
2196.	.
2197.	In App.js
2198.	Created new route
2199.	<Route path="/categories/:categoryId" element={<Categories />} />
2200.	.
2201.	…………………………………………………………………………………………………
2202.	.
2203.	In Home.js
2204.	import { Col, Container, Row } from "reactstrap";
2205.	import Base from "../components/Base";
2206.	import NewFeed from "../components/NewFeed";
2207.	import CategorySideMenu from "../components/CategorySideMenu";
2208.	
2209.	const Home = () => {
2210.	  return (
2211.	    <Base>
2212.	      <Container className="mt-3">
2213.	        <Row>
2214.	          <Col md={2} className="pt-5">
2215.	            <CategorySideMenu />
2216.	          </Col>
2217.	          <Col md={10}>
2218.	            <NewFeed />
2219.	          </Col>
2220.	        </Row>
2221.	      </Container>
2222.	    </Base>
2223.	  );
2224.	};
2225.	export default Home;
2226.	.
2227.	…………………………………………………………………………….
2228.	.
2229.	In NeewFeed.jsx
2230.	    return (
2231.	
2232.	        <div className="container-fluid">
2233.	            <Row>
2234.	                <Col md={
2235.	                    {
2236.	                        size: 12
2237.	                    }
2238.	                }>
2239.	.
2240.	==========================================================================================
2241.	.
2242.	Delete the post (logged in person only delete the post)
2243.	.
2244.	In UserDashboard.jsx
2245.	.
2246.	import React, { useEffect, useState } from 'react'
2247.	import Base from '../../components/Base'
2248.	import AddPost from '../../components/AddPost'
2249.	import { Container } from 'reactstrap'
2250.	import { getCurrentUserDetail } from '../../auth'
2251.	import { deletePostService, loadPostUserWise } from '../../services/post-service'
2252.	import { toast } from 'react-toastify'
2253.	import { Post } from '../../components/Post'
2254.	
2255.	const Userdashboard = () => {
2256.	  const [user, setUser] = useState({})
2257.	  const [posts, setPosts] = useState([])
2258.	  useEffect(() => {
2259.	    console.log(getCurrentUserDetail())
2260.	    setUser(getCurrentUserDetail())
2261.	    loadPostData()
2262.	  }, [])
2263.	
2264.	  function loadPostData(){
2265.	    loadPostUserWise(getCurrentUserDetail().id).then(data => {
2266.	      console.log(data)
2267.	      setPosts([...data])
2268.	    }).catch(error => {
2269.	      console.log(error)
2270.	      toast.error("error in loading user posts")
2271.	    })
2272.	  }
2273.	
2274.	  // ----------- function to delete post ---same in userdashboaer & Neew feed & categories---------------
2275.	  function deletePost(post){
2276.	    deletePostService(post.postId).then(resp=>{
2277.	      console.log(resp)
2278.	      toast.success("post is deleted..")
2279.	      
2280.	      let newPosts = posts.filter(p=>p.postId!==post.postId)
2281.	      setPosts([...newPosts])
2282.	    }).catch(error=>{
2283.	      console.log(error)
2284.	      toast.error("error in deleting post")
2285.	    })
2286.	  }
2287.	
2288.	  // -----------End of function to delete post -------------
2289.	  return (
2290.	    <Base>
2291.	      <Container>
2292.	        <AddPost />
2293.	        {/* --------------show posts user wise------------ */}
2294.	        <h1 className='my-3'>Posts count ({posts.length})</h1>
2295.	        {
2296.	          posts.map((post, index) => {
2297.	            return (
2298.	              <Post post={post} key={index} deletePost={deletePost} />
2299.	            )
2300.	          })
2301.	        }
2302.	        {/* --------------show posts user wise------------ */}
2303.	
2304.	      </Container>
2305.	    </Base>
2306.	  )
2307.	}
2308.	export default Userdashboard
2309.	.
2310.	…………………………………………………………………………………………………………….
2311.	
2312.	Categories.jsx
2313.	
2314.	import React, { useEffect, useState } from 'react'
2315.	import Base from '../components/Base'
2316.	import { useParams } from 'react-router-dom'
2317.	import { Col, Container, Row } from "reactstrap";
2318.	// import NewFeed from "../components/NewFeed";
2319.	import CategorySideMenu from "../components/CategorySideMenu";
2320.	import { deletePostService, loadPostCategoryWise } from '../services/post-service';
2321.	import { toast } from 'react-toastify';
2322.	import Post from '../components/Post';
2323.	
2324.	function Categories() {
2325.	    const [posts, setPosts] = useState([])
2326.	    // we are using useParams to fetch category
2327.	    const {categoryId} = useParams()
2328.	    useEffect(()=>{
2329.	        console.log(categoryId)
2330.	        loadPostCategoryWise(categoryId).then(data=>{
2331.	            setPosts([...data])
2332.	        }).catch(error=>{
2333.	            console.log(error)
2334.	            toast.error("error in loading posts")
2335.	        })
2336.	    }, [categoryId])
2337.	
2338.	    // ----------- function to delete post ---same in userdashboaer & Neew feed & categories---------------
2339.	  function deletePost(post){
2340.	    deletePostService(post.postId).then(resp=>{
2341.	      console.log(resp)
2342.	      toast.success("post is deleted..")
2343.	      
2344.	      let newPosts = posts.filter(p=>p.postId!==post.postId)
2345.	      setPosts([...newPosts])
2346.	    }).catch(error=>{
2347.	      console.log(error)
2348.	      toast.error("error in deleting post")
2349.	    })
2350.	  }
2351.	
2352.	  // -----------End of function to delete post -------------
2353.	
2354.	  return (
2355.	    <Base>
2356.	    <Container className="mt-3">
2357.	        <Row>
2358.	          <Col md={2} className="pt-5">
2359.	            <CategorySideMenu />
2360.	          </Col>
2361.	          <Col md={10}>
2362.	            <h1>Blogs Count ({posts.length})</h1>
2363.	            {
2364.	                posts && posts.map((post,index)=>{
2365.	                    return(
2366.	                        <Post deletePost={deletePost} key={index} post = {post}/>
2367.	                    )
2368.	                })
2369.	            }
2370.	            {posts.length<=0? <h1>No post in this category</h1> : ''}
2371.	          </Col>
2372.	        </Row>
2373.	      </Container>
2374.	    </Base>
2375.	  )
2376.	}
2377.	
2378.	export default Categories
2379.	.
2380.	………………………………………………………………………………………………………………………….
2381.	.
2382.	In NewFeed.jsx
2383.	.
2384.	import React, { useState } from 'react'
2385.	import { useEffect } from 'react'
2386.	import { deletePostService, loadAllPosts } from '../services/post-service'
2387.	import { Row, Col } from 'reactstrap'
2388.	// import { Row, Col, Pagination, PaginationItem, PaginationLink, Container } from 'reactstrap'
2389.	import Post from './Post'
2390.	import { toast } from 'react-toastify'
2391.	import InfiniteScroll from 'react-infinite-scroll-component'
2392.	
2393.	function NewFeed() {
2394.	
2395.	    const [postContent, setPostContent] = useState({
2396.	        content: [],
2397.	        lastPage: false,
2398.	        pageNumber: '',
2399.	        pageSize: '',
2400.	        totalElements: '',
2401.	        totalPages: ''
2402.	    })
2403.	
2404.	    // for infinite scroll -------------------------
2405.	    const [currentPage, setCurrentPage] = useState(0)
2406.	
2407.	    useEffect(() => {
2408.	        changePage(currentPage)
2409.	    }, [currentPage])
2410.	
2411.	    // for pagination 
2412.	    const changePage = (pageNumber = 0, pageSize = 5) => {
2413.	
2414.	        // for pagination increment and decrement
2415.	        if (pageNumber > postContent.pageNumber && postContent.lastPage) {
2416.	            return
2417.	        }
2418.	        if (pageNumber < postContent.pageNumber && postContent.pageNumber === 0) {
2419.	            return
2420.	        }
2421.	
2422.	        loadAllPosts(pageNumber, pageSize).then((data) => {
2423.	            setPostContent({
2424.	                content: [...postContent.content, ...data.content],
2425.	                lastPage: data.lastPage,
2426.	                pageNumber: data.pageNumber,
2427.	                pageSize: data.pageSize,
2428.	                totalElements: data.totalElements,
2429.	                totalPages: data.totalPages
2430.	            })
2431.	            console.log(data)
2432.	            // window.scroll(0, 0)
2433.	        }).catch(error => {
2434.	            toast.error("Error in loading post !!")
2435.	        })
2436.	    }
2437.	
2438.	    // ----------- function to delete post ---same in userdashboaer & Neew feed----------------
2439.	  function deletePost(post){
2440.	    deletePostService(post.postId).then(resp=>{
2441.	      console.log(resp)
2442.	      toast.success("post is deleted..")
2443.	      
2444.	      let newPostContents = postContent.content.filter(p=>p.postId!==post.postId)
2445.	      setPostContent({...postContent, content:newPostContents})
2446.	
2447.	    }).catch(error=>{
2448.	      console.log(error)
2449.	      toast.error("error in deleting post")
2450.	    })
2451.	  }
2452.	
2453.	  // -----------End of function to delete post -------------
2454.	
2455.	    // Infinite scroll -------------
2456.	    const changePageInfinite = () => {
2457.	        console.log("page changed")
2458.	        setCurrentPage(currentPage + 1)
2459.	    }
2460.	    // ----------------------------
2461.	
2462.	    return (
2463.	
2464.	        <div className="container-fluid">
2465.	            <Row>
2466.	                <Col md={
2467.	                    {
2468.	                        size: 12
2469.	                    }
2470.	                }>
2471.	                    <h1>Blogs Count ({postContent?.totalElements}) </h1>
2472.	
2473.	                    {/* ---------Infinite scroll-------- */}
2474.	                    <InfiniteScroll
2475.	                        dataLength={postContent.content.length}
2476.	                        next={changePageInfinite}
2477.	                        hasMore={!postContent.lastPage}
2478.	                        loader={<h4>Loading...</h4>}
2479.	                        endMessage={
2480.	                            <p style={{ textAlign: 'center' }}>
2481.	                                <b>Yay! You have seen it all</b>
2482.	                            </p>
2483.	                        }
2484.	                    >
2485.	                        {
2486.	                            postContent.content.map((post) => (
2487.	                                <Post deletePost={deletePost} post={post} key={post.postId} />
2488.	                            ))
2489.	                        }
2490.	                    </InfiniteScroll>
2491.	
2492.	                    {/* pagination from reactstrap ------------------------------------------------- */}
2493.	
2494.	                    {/* <Container className='mt-3'>
2495.	
2496.	                        <Pagination size='lg' >
2497.	
2498.	                            <PaginationItem onClick={() => changePage(postContent.pageNumber - 1)} disabled={postContent.pageNumber === 0}>
2499.	                                <PaginationLink previous>
2500.	                                    Previous
2501.	                                </PaginationLink>
2502.	                            </PaginationItem>
2503.	
2504.	                            {
2505.	                                [...Array(postContent.totalPages)].map((item, index) => (
2506.	                                    <PaginationItem onClick={() => changePage(index)} active={index === postContent.pageNumber} key={index}>
2507.	                                        <PaginationLink>
2508.	                                            {index + 1}
2509.	                                        </PaginationLink>
2510.	                                    </PaginationItem>
2511.	                                ))
2512.	                            }
2513.	
2514.	                            <PaginationItem onClick={() => changePage(postContent.pageNumber + 1)} disabled={postContent.lastPage}>
2515.	                                <PaginationLink next>
2516.	                                    Next
2517.	                                </PaginationLink>
2518.	                            </PaginationItem>
2519.	
2520.	                        </Pagination>
2521.	
2522.	                    </Container>----------------------------------------------------------------- */}
2523.	
2524.	                </Col>
2525.	            </Row>
2526.	        </div>
2527.	
2528.	    )
2529.	}
2530.	
2531.	export default NewFeed
2532.	.
2533.	…………………………………………………………………………………………………………………
2534.	.
2535.	In Post.jsx
2536.	.
2537.	import React, { useEffect, useState } from 'react'
2538.	import { Link } from 'react-router-dom'
2539.	import { Button, Card, CardBody, CardText } from 'reactstrap'
2540.	import { getCurrentUserDetail, isLoggedIn } from '../auth'
2541.	
2542.	export function Post({post={id:-1, title:"this is default post title", content:"this is default post content"}, deletePost}) {
2543.	  const [user,setUser] = useState(null)
2544.	  const [login, setLogin] = useState(null)
2545.	  useEffect(()=>{
2546.	    setUser(getCurrentUserDetail())
2547.	    setLogin(isLoggedIn())
2548.	  },[])
2549.	
2550.	
2551.	  return (
2552.	    
2553.	    <Card className='border-0 shadow-sm mt-3'>
2554.	        <CardBody>
2555.	            <h1>{post.title}</h1>
2556.	            {/* convert HTML to simple text */}
2557.	            <CardText dangerouslySetInnerHTML={{__html:post.content.substring(0,50)+"....."}}>
2558.	            </CardText>
2559.	            <div>
2560.	                <Link className='btn btn-secondary border-0' to={'/posts/'+post.postId}>Read More</Link>
2561.	
2562.	                {/* ------------------------to delete logged user post----------------------------- */}
2563.	                {isLoggedIn && (user && user.id===post.user.id ? <Button onClick={()=>deletePost(post)} color='danger' className='ms-2'>Delete</Button> : "")}
2564.	                {/* ------------------------to delete logged user post----------------------------- */}
2565.	
2566.	            </div>
2567.	        </CardBody>
2568.	    </Card> 
2569.	  )
2570.	}
2571.	
2572.	export default Post
2573.	.
2574.	……………………………………………………………………………………………………………………..
2575.	.
2576.	In post-service.jsx
2577.	.
2578.	// delete post
2579.	export function deletePostService(postId){
2580.	    return privateAxios.delete(`/posts/${postId}`).then((resp)=>resp.data)
2581.	}
2582.	.
2583.	==========================================================================================
2584.	.
2585.	.
2586.	…
2587.	.
2588.	.
2589.	.
2590.	..
2591.	.
2592.	.
2593.	..
2594.	.
2595.	.
2596.	.
2597.	.
2598.	..
2599.	.
2600.	.
2601.	.
2602.	.
2603.	.
2604.	.
2605.	.
2606.	
2607.	
2608.	.Continue video: 29
