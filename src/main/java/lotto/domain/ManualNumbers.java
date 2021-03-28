package lotto.domain;

import java.util.List;

public class ManualNumbers {

  private final List<String> manualNumbers;

  public ManualNumbers(List<String> manualNumbers) {
    this.manualNumbers = manualNumbers;
  }

  public List<String> manualNumbers() {
    return manualNumbers;
  }
}
