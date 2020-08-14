package step2;

public abstract class LottoStat {

  private final String message;
  private final int amount;

  public LottoStat(String message, int amount) {
    this.message = message;
    this.amount = amount;
  }

  public String getMessage() {
    return message;
  }

  public int getAmount() {
    return amount;
  }

  public int total() {
    return amount * getCount();
  }

  abstract int getCount();

  abstract void decide(int sameNumberCount);
}
