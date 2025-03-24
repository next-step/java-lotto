package calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private int result = 0;

    public int getResult() {
        return result;
    }

    public int add(int num) {
        return result + num;
    }

    public int subtract(int num) {
        return result - num;
    }

    public int multiply(int num) {
        return result * num;
    }

    public int divide(int num) {
        return result / num;
    }

    public int calculate(String sign, int num) {
        switch (sign) {
            case "+":
                return add(num);
            case "-":
                return subtract(num);
            case "*":
                return multiply(num);
            case "/":
                return divide(num);
        }
    }
}
