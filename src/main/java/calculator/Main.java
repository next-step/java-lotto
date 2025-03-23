package calculator;

import calculator.utils.InputView;
import calculator.utils.ResultView;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String input = new InputView(new Scanner(System.in)).receiveUserInput();
    int result = Calculator.calculate(input);
    ResultView.printResult(result);
  }
}
