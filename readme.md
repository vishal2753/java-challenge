### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your repository.

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

#### Your experience in Java

- I have around 4.5 years experience in Java and I have used Spring MVC and Spring Boot for about 2.5 years and in total 7 years of expereience.
- Initially I have worked on a project in which I have used functional programming language called Haskell for about 8months
- Then I have worked on various projects on Java and its various technologies like Spring, Struts, Play Framework and Spring Boot etc.
- My current project is based on Java using Seasar framework. 

- For this test I have have done my setup locally in Eclipse and used mvn plugins for Eclipse for execution of application.
- Changed in pom.xml - Set spring-boot to 2.5.5 for compatibility . Also swagger-ui and spring-fox swagger2 versions were upgraded
- Tested the controller.
- Used ResponseEntity to check the response status of the method in controller
- Created custom Exceptions and tested them
- Resolved dependency issue by adding dependencies like compiler, surfire etc.
- Not able to complete Actutor settings for health check of the application or add other end points 
- Caching on DB is not implementeddue to lack of experience in it but now I understand annotations like @EnableCaching etc.
- Wanted to use yaml file instead of settings file for more redability
- Application is running and have tested on swagger site
- All the requests and responses are OK

Improvements / TODO:
- Clean code
- Add logs
- Add proper comments
- Use of Actuator
- Use of caching system
- Seperation of the configuration logic setting
- Settings of Profiles for properties in test, development and production phases could be added



