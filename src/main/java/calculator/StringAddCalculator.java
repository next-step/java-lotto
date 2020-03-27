package calculator;

public class StringAddCalculator {

    public int calculate(String inputText) {
        IntegerParser integerParser = new IntegerParser(inputText);
        return integerParser.getNumber();
    }

}
