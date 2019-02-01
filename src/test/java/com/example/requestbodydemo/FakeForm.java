package com.example.requestbodydemo;

// Helper class to simulate wrong input which throws JSON Error on deserialization
public class FakeForm {

    private String positiveInteger = "Hallo";

    public String getPositiveInteger() {
        return positiveInteger;
    }
}