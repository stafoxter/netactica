package com.netactica.ticket.controller.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasajeroValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ICustomConstraint {
    String message() default "Ingrese nombre completo y edad del pasajero, o número de pasajero";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}