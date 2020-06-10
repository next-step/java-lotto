package calculator;


import java.util.List;

public class Calculator {
    private final StringParser stringParser;

    public Calculator() {
        stringParser = new StringParser();
    }

    public int sum(String input) {
        return getSum(stringParser.getNumbers(input));
    }

    private int getSum(List<Integer> numbers){
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
