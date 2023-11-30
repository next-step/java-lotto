package lotto.enums;

import java.util.function.BiFunction;

public enum LottoResultType {

  THREE(3,5000)
  , FOUR(4,50000)
  , FIVE(5,1500000)
  , ALL(6,2000000000)
  , NO_MATCH(0,0)
  ;
  private final int number;
  private final double price;
  private BiFunction resultFunction;

  LottoResultType(int number, double price) {
    this.number = number;
    this.price = price;
  }

  public double calculatePrice(double count) {
    return price * count;
  }

  public boolean sameNumber(int number) {
    return this.number == number;
  }

}
