package lotto3.domain;

public class ManualLottoCount {

  private final int count;

  public ManualLottoCount(int count) {
    this.count = count;
    validateIsPositive();
  }

  private void validateIsPositive() {
    if (count < 0) {
      throw new IllegalArgumentException("수동으로 구매할 로또 수는 0보다 커야합니다.");
    }
  }

  public int getCount() {
    return count;
  }

}
