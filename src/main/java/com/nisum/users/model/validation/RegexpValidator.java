package com.nisum.users.model.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class RegexpValidator implements ConstraintValidator<Regexp, String>  {
    private Environment env;
    private String regexpKey;

    @Autowired
    public RegexpValidator(Environment env) {
        this.env = env;
    }

    @Override
    public void initialize(Regexp constraintAnnotation) {
        this.regexpKey = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String regexp = env.getProperty(regexpKey);
        if (regexp == null || "".equals(regexp.trim()))
            return true;

        return value.matches(regexp);
    }
}
