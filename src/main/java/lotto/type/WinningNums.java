package lotto.type;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNums {

  private final List<Integer> winningNums;

  public static WinningNums valueOf(String expression, int lottoNumSize) {
    return new WinningNums(expression, lottoNumSize);
  }

  public WinningNums(String expression, int lottoNumSize) {
    List<String> expressionToken = List.of(expression.split(","));
    this.winningNums = expressionToken.stream()
        .map(token -> Integer.parseInt(token.trim()))
        .collect(Collectors.toList());

    if (new HashSet<>(winningNums).size() != lottoNumSize) {
      throw new IllegalArgumentException("당첨 번호 수가 유효하지 않습니다.");
    }
  }

  public boolean contains(int num) {
    return winningNums.contains(num);
  }
}
