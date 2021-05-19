package step2;

public class Calculator {

    public int addNumberBetweenSeparator(String input) {
        int result = 0;
        if (!checkNull(input)) {
            String[] numbers = separateWithSeparator(input);
            result = addNumbers(numbers);
        }
        return result;
    }

    private int addNumbers(String[] numbers) {
        int result = 0;
        for (String numbesr : numbers) {
            result += parseNumber(numbesr);
        }
        return result;
    }

    private int parseNumber(String numbesr) {
        return Integer.parseInt(numbesr);
    }

    private String[] separateWithSeparator(String input) {
        return input.split(",|:");
    }

    private boolean checkNull(String input) {
        return null == input || "".equals(input.trim());
    }

}
