package stringcalculator;

import java.util.Scanner;
import stringcalculator.domain.StringCalculator;

public class Application {

  public static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    String input = sc.nextLine();

    System.out.println("결과 : " + new StringCalculator(input).calculate());
  }
}
