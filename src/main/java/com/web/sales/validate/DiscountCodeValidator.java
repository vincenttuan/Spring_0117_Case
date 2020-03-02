package com.web.sales.validate;

import com.web.sales.models.DiscountCode;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DiscountCodeValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return DiscountCode.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        DiscountCode dc = (DiscountCode)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discountCode", "discountCode.discountCode.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rate", "discountCode.rate.empty");
        
        if(dc.getRate() != null && (dc.getRate() < 0.0 || dc.getRate() > 100.0)) {
            errors.rejectValue("rate", "discountCode.rate.invalid");
        }
        
    }
    
}
