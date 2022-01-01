package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private static final String QUESTION_BUY_AMOUNT = "구입금액을 입력해 주세요.";
  private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String SPLIT_STRING = ",";
  private static final Scanner scanner = new Scanner(System.in);

  public long inputBuyAmount() {
    printQuestion(QUESTION_BUY_AMOUNT);
    return scanner.nextLong();
  }

  public List<Integer> inputWinningNumbers() {
    printQuestion(QUESTION_WINNING_NUMBERS);
    String[] winningNumbers = scanner.next().split(SPLIT_STRING);
    return Arrays.stream(winningNumbers).map(Integer::parseInt).collect(Collectors.toList());
  }

  private void printQuestion(String question) {
    System.out.println(question);
  }
}

