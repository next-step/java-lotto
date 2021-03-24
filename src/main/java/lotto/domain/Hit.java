package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.constant.Constant;

public enum Hit {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private int hitNumber;
  private int prize;

  Hit(int hitNumber, int prize) {
    this.hitNumber = hitNumber;
    this.prize = prize;
  }

  public static Hit getHit(int hitNumber) {
    return Arrays.stream(values())
        .filter(hit -> hit.hitNumber == hitNumber)
        .findFirst()
        .orElse(MISS);
  }

  public static List<Hit> all() {
    return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
  }

  public String showHitResult() {
    if (prize == Constant.BONUS_PRIZE) {
      return String.format("%d개 일치, 보너스 볼 일치(%d원)-", hitNumber, prize);
    }
    return String.format("%d개 일치 (%d원)-", hitNumber, prize);
  }

  public int prize() {
    return prize;
  }

  public static Hit getBonusHit(boolean hitBonus) {
    if (hitBonus) {
      return Hit.SECOND;
    }
    return Hit.THIRD;
  }
}