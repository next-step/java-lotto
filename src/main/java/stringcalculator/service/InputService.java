package stringcalculator.service;

import java.util.Scanner;
import stringcalculator.domain.InputValue;

public class InputService {

  public final Scanner sc = new Scanner(System.in);

  public InputValue input() {
    String input = sc.nextLine();

    return new InputValue(input);
  }
}
