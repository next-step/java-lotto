package step1;

import java.util.List;

public class Calculator {
    List<Integer> inputValues;

    Calculator(List<Integer> inputValues) {
        this.inputValues = inputValues;
    }

    public int getSum() {
        int sum = 0;
        for (Integer inputValue : inputValues) {
            sum += inputValue;
        }
        return sum;
    }

}
