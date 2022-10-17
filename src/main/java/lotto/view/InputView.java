package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

  private static final String COMMA = ",";

  private InputView() {
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static int getPrice() {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException("로또 구매가격은 숫자만 입력 가능합니다");
    }
  }

  public static Set<Integer> getWeekendNumbers() {
    return Arrays.stream(scanner.next().split(COMMA))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
  }
}
