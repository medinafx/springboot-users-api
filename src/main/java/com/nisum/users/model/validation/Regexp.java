package com.nisum.users.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RegexpValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Regexp {
    String message() default "The format is invalid";

    String regexp() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
