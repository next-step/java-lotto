package stringcaculator.application;

import stringcaculator.domain.*;
import stringcaculator.domain.Number;

import java.util.Scanner;

public class CalculatorApplication {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();

      Delimeter delimeter = new Delimeter(new Input(input).validValue());

      Numbers numbers = new Numbers(delimeter.splitedInput());

      StringCalculator stringCalculator = new StringCalculator(numbers);
      Number result = stringCalculator.calculation();

      System.out.println(result.getValue());
   }
}
