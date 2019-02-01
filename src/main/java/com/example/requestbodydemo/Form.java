package com.example.requestbodydemo;

import javax.validation.constraints.Positive;

public class Form {

    @Positive
    private Integer positiveInteger;

    public Integer getPositiveInteger() {
        return positiveInteger;
    }

    public void setPositiveInteger(Integer positiveInteger) {
        this.positiveInteger = positiveInteger;
    }
}
