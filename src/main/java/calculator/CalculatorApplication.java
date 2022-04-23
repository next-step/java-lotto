package calculator;

import calculator.domain.Calculator;
import java.util.Scanner;

public class CalculatorApplication {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("계산하려는 식을 입력해주세요.");
    Calculator calculator = new Calculator(SCANNER.nextLine());
    System.out.println("계산 결과 : " + calculator.calculate());
  }
}
