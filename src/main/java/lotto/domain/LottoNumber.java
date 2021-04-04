package lotto.domain;

import java.util.Random;

public class LottoNumber {
  private final int lottoNumber;

  private LottoNumber(int lottoNumber) {
    this.lottoNumber = lottoNumber;
  }

  public static LottoNumber generate() {
    return new LottoNumber(randomNumber());
  }

  private static int randomNumber() {
    return new Random().nextInt(45) + 1;
  }

  public boolean isValidNumberRange() {
    return 0 < lottoNumber && lottoNumber <= 45;
  }
}
