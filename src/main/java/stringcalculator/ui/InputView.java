package stringcalculator.ui;

import java.util.Scanner;
import stringcalculator.domain.InputValue;

public class InputView {

  public static final Scanner sc = new Scanner(System.in);

  private InputView() {
  }

  public static InputValue input() {
    String input = sc.nextLine();

    return new InputValue(input);
  }
}
