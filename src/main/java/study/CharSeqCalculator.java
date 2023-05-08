package study;

import java.util.List;

public class CharSeqCalculator {
    public static void main(String[] args) {

        String input = ConsoleScanner.input();
        List<String> values = StringUtils.split(input);
        ExpressionContainer expressionContainer = new ExpressionContainer(values);

        System.out.println(expressionContainer.calculate());

    }
}
