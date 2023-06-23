package lotto.domain;

public class ManualPurchaseNumber {

  private final int value;

  public ManualPurchaseNumber(int value, int purchasableTicketNumber) {
    validate(value, purchasableTicketNumber);
    this.value = value;
  }

  public ManualPurchaseNumber(String value, int purchasableTicketNumber) {
    this(toInt(value), purchasableTicketNumber);
  }

  public int value() {
    return this.value;
  }

  private static int toInt(String value) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("수동으로 입력될 수 있는 값은 음이 아닌 정수 뿐입니다. 입력된 값 : " + value);
    }
  }

  private void validate(int value, int purchasableTicketNumber) {
    if (value > purchasableTicketNumber) {
      throw new IllegalArgumentException(String.format("입력받은 수동 구입 숫자가 지불한 티켓 금액보다 큽니다. 입력받은 수동 구입 수: %d, 구입할 수 있는 티켓 수: %d", value, purchasableTicketNumber));
    }

    if (value < 0) {
      throw new IllegalArgumentException("입력받은 수동 구입 숫자는 0보다 큰 정수여야 합니다. 입력받은 수동 구입 수: " + value);
    }
  }
}
