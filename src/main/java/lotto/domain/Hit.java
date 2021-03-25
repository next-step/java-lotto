package lotto.domain;

import java.util.Arrays;
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

  public static int countHit(HitNumbers hitNumbers, LottoNumbers lottoNumbers) {
    return (int) lottoNumbers.numbers()
        .stream()
        .filter(hitNumbers::contains).count();
  }

  public static Hit getHit(HitNumbers hitNumbers, LottoNumbers numbers) {
    int hitNumber = countHit(hitNumbers, numbers);

    if (hitNumber == Constant.HIT_OF_BONUS) {
      return getBonusHit(hitNumbers.containsBonus(numbers));
    }

    return Arrays.stream(values())
        .filter(hit -> hit.hitNumber == hitNumber)
        .findFirst()
        .orElse(MISS);
  }

  public int prize() {
    return prize;
  }

  public int hitNumber() {
    return hitNumber;
  }

  public static Hit getBonusHit(boolean hitBonus) {
    if (hitBonus) {
      return Hit.SECOND;
    }
    return Hit.THIRD;
  }
}