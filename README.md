## Introduction
**Validation** is my project in which I am using hibernate validation and I am creating a new type of validations.

## End Points
**Clients** <p>
* ```localhost:8080/clients/add | To create a new client```
* ```localhost:8080/clients/all | To get all clients```
* ```localhost:8080/clients/findUser/{id} | To get a specific client```
* ```localhost:8080/clients/remove/{id} | To remove a specific client```

## How to make new validation
You will make a @inteface like that: <p>
(You can copy that and paste in your IDE to see this better) <p>
@Documented  <p>
@Target(ElementType.PARAMETER) // Where the annotation are used <p>
@Retention(RetentionPolicy.RUNTIME) // The type of retention <p>
@Constraint(validatedBy = ClientNotFoundValidation.class) // To indicate the class is used to validate<p>
public @interface ClientNotFound { <p>
String message() default "We have not any client with this ID";  //The mensaje who will be return when the program throw exception for validation <p>
Class<?>[] groups() default {}; <p>
Class<?>[] payload() default {};} <p>

After that you will make a class like that: <p>
//This class must implement ConstraintValidator<@inteface that you created, the value that will be validated> <p>
public class ClientDoNotExistValidation implements ConstraintValidator<ClientDoNotExist, Client> { <p>

    /**
     * Used to vilid if the client exist
     */
    private ClientService clientService;

    /**
     * Constructor the ClientDoNotExistValidation
     * 
     * @param clientService - to find the user
     */
    public ClientDoNotExistValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Comprobe if the user exist or not
     * 
     * @param value - client to valid to exist or not
     * @return true if the user don´t exist, false if the user exist
     */
    @Override
    public boolean isValid(Client value, ConstraintValidatorContext context) {
        if (clientService.findByUsername(value.getUserName()) == null) {
            return true;
        }

        return false;
    }
