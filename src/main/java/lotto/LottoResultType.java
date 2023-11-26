package lotto;

public enum LottoResultType {

  THREE(5000)
  , FOUR(50000)
  , FIVE(1500000)
  , ALL(2000000000)
  ;

  private final double price;

  LottoResultType(double price) {
    this.price = price;
  }

  public double calculatePrice(double count) {
    return price * count;
  }
}
