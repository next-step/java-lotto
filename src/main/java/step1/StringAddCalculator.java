package step1;

public class StringAddCalculator {
    private StringAddCalculator() {
    }

    static int splitAndSum(String input) {
        if (input.length() == UserInput.LENGTH_ONE) {
            return Integer.parseInt(input);
        }
        //Split
        String[] splitedInputs = StringSpliter.findCustomDelimiter(input);

        //Sum
        int result = ElementAdder.addAllElements(splitedInputs);
        return result;
    }
}


