package com.blog.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="post")
@Getter
@Setter
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name="title", length=100, nullable=false)
	private String title;
	
	@Column(length=1000000000)
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	// comes from category.
	// Many Post have one category(ManyToOne)
	// ManyToOne- One category - column will be create.
	@ManyToOne
	private Category category;
	
	// Only Post Table will have additional column (Category, User)
	// no changes in category and user table.
	// ManyToOne can create table.
	@ManyToOne
	private User user;
	
	// only in comment table will create
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();
}
