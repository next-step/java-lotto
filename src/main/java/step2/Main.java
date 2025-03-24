package step2;

import java.util.Scanner;

import step2.domain.Calculator;
import step2.domain.ExpressionElement;
import step2.domain.StringParser;
import step2.view.InputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        StringParser parser = new StringParser();
        ExpressionElement element = parser.splitExpression(inputView.input());
        System.out.println(Calculator.calculate(element));
    }
}
