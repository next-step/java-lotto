package calculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  public static final Scanner scanner = new Scanner(System.in);
  public static final String SPACE_DELIMITER = " ";

  public static List<String> inputOperation() {
    System.out.println("계산할 수식을 작성해주세요.");
    System.out.println("입력하는 수식의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있어야 합니다.");

    return splitOperation(scanner.nextLine());
  }

  private static List<String> splitOperation(String operation) {
    return Arrays.stream(operation.split(SPACE_DELIMITER))
            .collect(Collectors.toList());
  }
}
