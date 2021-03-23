package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Hit {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000),
  MISS(0, 0);

  private int hitNumber;
  private int prize;

  Hit(int hitNumber, int prize) {
    this.hitNumber = hitNumber;
    this.prize = prize;
  }

  public static Hit getHitCount(int hitNumber) {
    return Arrays.stream(values())
        .filter(hit -> hit.hitNumber == hitNumber)
        .findFirst()
        .orElse(MISS);
  }

  public static List<Hit> all() {
    return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
  }

  public String showHitResult() {
    return String.format("%d개 일치 (%d원)-", hitNumber, prize);
  }

  public int prize() {
    return prize;
  }

}