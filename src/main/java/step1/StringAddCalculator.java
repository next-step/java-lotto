package step1;

public class StringAddCalculator {
    public static int splitAndSum(String inputString) {
        String[] splitStrings = Split.split(inputString);
        Integer[] parseNumbers = Parser.parse(splitStrings);
        int result = Calculator.add(parseNumbers);
        return result;
    }
}
