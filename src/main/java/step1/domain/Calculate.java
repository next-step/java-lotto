package step1.domain;

import java.util.ArrayList;

public class Calculate {

    private ArrayList<String> calculates = new ArrayList<>();
    public void addCalculate(String value) {
        calculates.add(value);
    }

    public ArrayList<String> getcalculates() {
        return calculates;
    }
    //덧셈
    public int add(int previousNumber, int nextNumber) {
        return previousNumber + nextNumber;
    }

    //뺄셈
    public int substract(int previousNumber, int nextNumber) {
        return previousNumber - nextNumber;
    }

    //곱셈
    public int multiply(int previousNumber, int nextNumber) {
        return previousNumber * nextNumber;
    }

    //나눗셈
    public int divide(int previousNumber, int nextNumber) {
        if(previousNumber % nextNumber != 0) {
            throw new IllegalArgumentException("나눗셈이 정수로 떨이지지 않습니다.");
        }
        return previousNumber / nextNumber;
    }

}
