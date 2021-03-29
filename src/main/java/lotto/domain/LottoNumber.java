package lotto.domain;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber>{

  public static final int START_NUMBER = 1;
  public static final int END_NUMBER = 45;
  public static HashMap<Integer, LottoNumber> lottoNumbersRange = new HashMap<>();
  private final int number;

  static {
    for (int i = START_NUMBER; i <= END_NUMBER; i++) {
      lottoNumbersRange.put(i, new LottoNumber(i));
    }
  }

  private LottoNumber(int number) {
    if (number < START_NUMBER || number > END_NUMBER) {
      throw new IllegalArgumentException("out of bound.");
    }
    this.number = number;
  }

  public static LottoNumber generateManual(int number) {
    LottoNumber lottoNumber = lottoNumbersRange.get(number);
    if (lottoNumber == null) {
      throw new IllegalArgumentException("out of bound.");
    }
    return lottoNumber;
  }

  public static LottoNumber generateAuto() {
    Random random = new Random();
    int number = random.nextInt(45) + 1;
    return lottoNumbersRange.get(number);
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    if (lottoNumber.number > number) {
      return -1;
    }
    return 1;
  }

}
