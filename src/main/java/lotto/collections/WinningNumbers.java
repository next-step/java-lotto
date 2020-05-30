package lotto.collections;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningNumber;

public class WinningNumbers {

  List<WinningNumber> winningNumbers;

  public WinningNumbers(List<Integer> winningNumberLists) {
    super();
    this.winningNumbers = createWinningNumbers(winningNumberLists);
  }

  private List<WinningNumber> createWinningNumbers(List<Integer> winningNumberLists) {
    List<WinningNumber> numbers = new ArrayList<>();
    for (int number: winningNumberLists) {
      numbers.add(new WinningNumber(number));
    }
    return numbers;
  }

  public List<WinningNumber> getWinningNumbers() {
    return winningNumbers;
  }
}
