package lotto.domain;

import java.util.List;

public class LottoGame {

  private final List<LottoBall> draw;

  public LottoGame() {
    draw = LottoBallFactory.draw();
  }

}
