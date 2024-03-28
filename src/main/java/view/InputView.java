package view;

import domain.lotto.vo.LottoNumber;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private final Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public int inputInteger() {
    int input = scanner.nextInt();
    scanner.nextLine();
    return input;
  }

  public List<Integer> inputIntegerList() {
    return Arrays.stream(scanner.nextLine().split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
