package lotto.domain;

public class WinningNumber {

  private Integer number;

  public WinningNumber(Integer number) {
    validateNumberInRange(number);
    this.number = number;
  }

  private void validateNumberInRange(Integer number) {
    if (number < 1 || number > 45) {
      throw new RuntimeException("winning number should be in between 1 and 45.");
    }
  }

  public Integer getNumber() {
    return number;
  }
}
