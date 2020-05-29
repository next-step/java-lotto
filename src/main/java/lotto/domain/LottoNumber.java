package lotto.domain;

import java.util.Random;

public class LottoNumber {

  public static final int MINIMUM_NUMBER_BOUND = 1;
  public static final int MAXIMUM_NUMBER_BOUND = 45;

  private int number;

  public LottoNumber() {
    this.number = new Random().nextInt(getLottoNumberInRange());
  }

  public int getNumber() {
    return number;
  }

  private int getLottoNumberInRange() {
    return new Random().nextInt((MAXIMUM_NUMBER_BOUND - MINIMUM_NUMBER_BOUND) + 1)
        + MINIMUM_NUMBER_BOUND;
  }
}
