## Maven, Spring Boot, JPA learning project

This was a small project built with intention of learning Maven, Spring Boot and JPA.

- [Maven – Guide to Naming Conventions](https://maven.apache.org/guides/mini/guide-naming-conventions.html)
- [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)
- [Spring Boot](https://spring.io/projects/spring-boot/)
- [Spring | Quickstart](https://spring.io/quickstart/)
- [Spring Initializr](https://start.spring.io/)
- [MariaDB Enterprise Open Source Database & SkySQL MariaDB Cloud | MariaDB](https://mariadb.com/)
- [SLF4J](https://www.slf4j.org/)
- [Getting Started | Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Apache Tomcat® - Welcome!](https://tomcat.apache.org/)

There were a few additional interesting learnings:
- The Spring JPA Repository based on the naming of the methods is able to understand what queries to build. In case 
  you use completely custom names, you'll need to write the queries yourself. [JPA Query Methods :: Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
- Another one was about the connection between MariaDB and Spring boot: [hibernate - Why am I obtaining this error trying to perform the insert of a record using Spring Data JPA? Table 'db_test.hibernate_sequence' doesn't exist - Stack Overflow](https://stackoverflow.com/questions/60830254/why-am-i-obtaining-this-error-trying-to-perform-the-insert-of-a-record-using-spr)
- Also, that you can't have multiple GetMappings on the same URL even if the parameters to be passed are different. 
  You need to create one mapping and inside it handle the possible combinations of parameters.
- Was interesting to learn how we can generate JAR files for our projects and directly execute them, something we 
  get detached from in a corporate environment. 
