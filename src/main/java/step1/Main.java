package step1;

import step1.arithmeticExpression.ArithmeticExpression;
import step1.arithmeticExpression.ExpressionAsArithmeticExpression;
import step1.print.ConsoleInput;
import step1.print.ConsoleOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ConsoleInput consoleInput = new ConsoleInput();
        String expression = consoleInput.input();

        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(new ExpressionAsArithmeticExpression(expression));

        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.output(arithmeticExpression);

        br.close();
    }

}
