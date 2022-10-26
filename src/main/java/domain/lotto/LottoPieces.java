package domain.lotto;

public class LottoPieces {

  public int pieces;

  public LottoPieces(int payment) {
    validatePrice(payment);
    int pieces = payment / 1000;
    this.pieces = pieces;
  }

  private void validatePrice(int amount) {
    if (amount % 1000 != 0) {
      throw new IllegalArgumentException("1000원 단위로만 구매할 수 있습니다");
    }
  }

}
