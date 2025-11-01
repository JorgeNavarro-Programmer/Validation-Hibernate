## Introduction
**Validation** is my project in which I am using hibernate validation and I am creating a new type of validations.

## How to make new validation
You will make a @inteface like that: (You can copy that and paste in your ide)<p>
@Documented   <p>
@Target(ElementType.PARAMETER) // Where the annotation are used <p>
@Retention(RetentionPolicy.RUNTIME) // The type of retention <p>
@Constraint(validatedBy = ClientNotFoundValidation.class) // To indicate the class is used to validate<p>
public @interface ClientNotFound { <p>
String message() default "We have not any client with this ID"; <p>

Class<?>[] groups() default {}; <p>

Class<?>[] payload() default {};}

## End Points
**Clients** <p>
* ```localhost:8080/clients/add | To create a new client```
* ```localhost:8080/clients/all | To get all clients```
* ```localhost:8080/clients/findUser/{id} | To get a specific client```
* ```localhost:8080/clients/remove/{id} | To remove a specific client```
