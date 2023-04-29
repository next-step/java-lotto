package step1.service;

import step1.domain.Calculate;
import step1.domain.Number;

public class CalculateService {
    public String[] split(String inputValue) {
        return inputValue.split(" ");
    }
    public Number sectionNumber(String[] values) {
        Number number = new Number();
        for(int i=0; i < values.length; i+=2) {
            isBlank(values[i]);
            number.addNumber(Integer.parseInt(values[i]));
        }
        return number;
    }

    public Calculate sectionCalculate(String[] values) {
        Calculate calculate = new Calculate();
        for(int i=1; i < values.length; i+=2) {
            isBlank(values[i]);
            calculate.addCalculate(values[i]);
        }
        return calculate;
    }

    private void isBlank(String value) {
        if(value.isBlank()) {
            throw new IllegalArgumentException("입력값이 Null 이거나 빈 공백 문자입니다.");
        }
    }

    public int calculate(Number numbers, Calculate calculates) {
        int number = numbers.getNumbers().get(0);
        for(int i = 1; i < numbers.getNumbers().size(); i++ ) {
            switch (calculates.getcalculates().get(i - 1)) {
                case "*":
                    number = calculates.multiply(number, numbers.getNumbers().get(i));
                    break;
                case "+":
                    number = calculates.add(number, numbers.getNumbers().get(i));
                    break;
                case "-":
                    number = calculates.substract(number, numbers.getNumbers().get(i));
                    break;
                case "/":
                    number = calculates.divide(number, numbers.getNumbers().get(i));
                    break;
                default:
                    throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
            }
        }
        return number;
    }
}
