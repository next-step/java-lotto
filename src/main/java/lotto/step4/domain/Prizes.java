package lotto.step4.domain;

import java.util.List;
import java.util.stream.Stream;

public class Prizes {
  private final List<Prize> prizes;

  private Prizes(List<Prize> prizes) {
    this.prizes = prizes;
  }

  public static Prizes of (List<Prize> prizes) {
    return new Prizes(prizes);
  }

  public Stream<Prize> stream () {
    return prizes.stream();
  }
}
