package step2;

public class StringAddCalculator {

    int calculate(String input) {
        return sum(new Numbers().getNumberArray(input));
    }

    private int sum(int[] numberArray) {
        int result = 0;
        for(int number : numberArray) {
            result += number;
        }
        return result;
    }
}
