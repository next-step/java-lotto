package model;

import java.util.ArrayList;
import java.util.List;

public class Operator {
    public static List<String> VALID_OPERATORS =  List.of("+","-","*","/");

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        if(num2 == 0){
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}
