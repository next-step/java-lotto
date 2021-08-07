package calculator;

import calculator.common.CustomSeparatorParser;
import calculator.common.CustomSeparatorUsableChecker;
import calculator.common.IntegerParser;
import calculator.domain.CalculateParser;
import calculator.domain.Calculator;

public class Main {
    public static void main(String[] args) {
        String value = "//@\\n1:2,3@4";
//        String value = "1:2,3:4:5";
        CustomSeparatorUsableChecker checker = new CustomSeparatorUsableChecker();
        Calculator calculator = new Calculator();
        CalculateParser calculateParser = new CalculateParser();
        String[] elements = parseElements(value, checker, calculateParser);
        System.out.println(calculator.addEachAll(elements, new IntegerParser()));
    }

    private static String[] parseElements(String value, CustomSeparatorUsableChecker checker, CalculateParser calculateParser) {
        if(checker.check(value)) {
            CustomSeparatorParser customSeparatorParser = new CustomSeparatorParser();
            String customSeparator = customSeparatorParser.parse(value);
            return calculateParser.parse(customSeparator, value.substring(5));
        }
        return calculateParser.parse(value);
    }
}
