package lotto.domain;

import java.util.List;

public class Purchase {

  private final Amount amount;
  private final List<String> manualNumbers;

  public Purchase(Amount amount, List<String> manualNumbers) {
    this.amount = amount;
    this.manualNumbers = manualNumbers;
  }

  public List<String> manualNumbers() {
    return manualNumbers;
  }

  public Amount getAmount() {
    return amount;
  }
}
