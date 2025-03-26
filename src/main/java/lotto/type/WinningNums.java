package lotto.type;

import lotto.LottoSystemConstants;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNums {

  private final List<Integer> winningNums;

  public static WinningNums valueOf(String expression) {
    return new WinningNums(expression);
  }

  public WinningNums(String expression) {
    List<String> expressionToken = List.of(expression.split(","));
    winningNums = expressionToken.stream()
        .map(token -> Integer.parseInt(token.trim()))
        .collect(Collectors.toList());

    if (new HashSet<>(winningNums).size() != LottoSystemConstants.LOTTO_SIZE) {
      throw new IllegalArgumentException("당첨 번호 수가 유효하지 않습니다.");
    }

    if (winningNums.stream().anyMatch(num -> num > LottoSystemConstants.LOTTO_MAX_NUM) || winningNums.stream().anyMatch(num -> num < LottoSystemConstants.LOTTO_MIN_NUM)) {
      throw new IllegalArgumentException("당첨 번호가 유효하지 않습니다.");
    }
  }

  public boolean contains(int num) {
    return winningNums.contains(num);
  }
}
