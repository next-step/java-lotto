package lotto.domain;

import java.util.List;

public class LottoBalls {

  private List<LottoBall> lottoBalls;

  public LottoBalls(List<LottoBall> lottoBalls) {
    this.lottoBalls = lottoBalls;
  }

  public int size() {
    return lottoBalls.size();
  }

  public String numbersString() {
    return lottoBalls.stream()
        .map(ball -> String.valueOf(ball.getNumber()))
        .reduce((d1, d2) -> String.join(",", d1,d2))
        .orElseThrow(() -> new IllegalArgumentException("로또 번호 문자열 변환 실패"));
  }
}
