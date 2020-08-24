package step1;

public class StringAddCalculator {
    private StringAddCalculator() {
    }

    static int splitAndSum(String input) {
        if (input.length() == UserInput.LENGTH_ONE) {
            System.out.println("hhhh");
            return Integer.parseInt(input);
        }
        String[] splitedInputs = StringSpliter.findCustomDelimiter(input);
        int result = ElementAdder.addAllElements(splitedInputs);
        return result;
    }
}


