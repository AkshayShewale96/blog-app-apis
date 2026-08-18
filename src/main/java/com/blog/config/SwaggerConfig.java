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
	
	// add security in swagger - using Bean
	
//	@Bean
//	  public OpenAPI springShopOpenAPI() {
//		
//		String schemeName = "bearerScheme";
//		
//	        return new OpenAPI()
//	        		.addSecurityItem(new SecurityRequirement()
//	        				.addList(schemeName))
//	        		
//	        		.components(new Components()
//	        				.addSecuritySchemes(schemeName, new SecurityScheme()
//	        						.name(schemeName)
//	        						.type(SecurityScheme.Type.HTTP)
//	        						.bearerFormat("JWT")
//	        						.scheme("bearer")
//	        						))
//	        		
//	                .info(new Info().title("Blog Application")
//	                .description("Upload pics, give comment")
//	                .version("v0.0.1")
//	                .contact(new Contact().name("Akshay").email("shewaleakshay1996@gmail.com").url("ravan.com"))
//	                .license(new License().name("Apache 2.0 - Open License").url("http://springdoc.org")))
//	                .externalDocs(new ExternalDocumentation()
//	                .description("ex - SpringShop Wiki Documentation")
//	                .url("ex - https://springshop.wiki.github.org/docs"));
//	    }
}
