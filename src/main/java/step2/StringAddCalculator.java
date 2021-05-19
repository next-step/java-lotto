package step2;

public class StringAddCalculator {

    public int calculate(String input) {
        int result = 0;
        for(int number : new Numbers().getNumberArray(input)) {
            result += number;
        }

        return result;
    }
}
