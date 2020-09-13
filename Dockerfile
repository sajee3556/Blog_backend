FROM openjdk:latest
ADD target/blog.jar blog.jar
ENTRYPOINT ["java","-jar","blog.jar"]
EXPOSE 8080