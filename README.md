generic repository
https://dzone.com/articles/customizing-spring-data-jpa

Mapping
https://dzone.com/articles/remap-robus-java-object-mapping-with-minimal-testing-overhead

Lombok
https://programmingmitra.blogspot.in/2017/01/Project-Lombok-The-Boilerplate-Code-Extractor.html

https://techblog.bozho.net/custom-audit-log-with-spring-and-hibernate/

https://docs.jboss.org/hibernate/orm/4.3/devguide/en-US/html/ch15.html

http://www.oodlestechnologies.com/blogs/Introduction-to-Javers-And-Its-Integration-To-Spring-Boot

 @JsonCreator
    public PersonDto(@JsonProperty("id") Integer id,
                     @JsonProperty("firstName") String firstName,
                     @JsonProperty("lastName") String lastName,
                     @JsonProperty("sex") String sex,
                     @JsonProperty("salary") Integer salary,
                     @JsonProperty("position") String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.salary = salary;
        this.position = position;
    }
https://stackoverflow.com/questions/33744875/spring-boot-how-to-log-all-requests-and-responses-with-exceptions-in-single-pl

spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
management.trace.include=parameters,errors
endpoints.trace.sensitive=false

Spring Boot does not support logging request and response body. However, it should be fairly easy to get this going. I’d suggest you start with the provided implementation of WebRequestTraceFilter. This is the class that captures the requests and responses for trace logging. You could extend it to capture anything you like.
Spring Boot autoconfigures a WebRequestTraceFilter bean using the @ConditionalOnMissingBean annotation – see TraceWebFilterAutoConfiguration. That should mean that if you declare your own subclass implementation of WebRequestTraceFilter as a Bean, Spring Boot should pick up your custom implementation instead of the provided one.

http://www.sedooe.com/2017/08/tracing-requests-and-responses-with-spring-boot-actuator/

try: zipkin

https://github.com/spring-projects/spring-data-examples/tree/master/rest/security
http
  .httpBasic().and()
  .authorizeRequests()
    .antMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN")
    .antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
    .antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN");
    
http://shout.setfive.com/2015/11/02/spring-boot-authentication-with-custom-http-header/
