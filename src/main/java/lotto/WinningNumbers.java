package lotto;

public class WinningNumbers {

  private final Integer[] winningNumbers;

  public WinningNumbers(String input) {
    this.winningNumbers = toIntegers(split(input));
  }

  public int howManyMatches(Lotto lotto) {
    int matchesNumber = 0;
    for (Integer winningNumber : winningNumbers) {
      if (lotto.has(winningNumber)) {
        matchesNumber++;
      }
    }
    return matchesNumber;
  }

  private Integer[] toIntegers(String[] tokens) {
    if (tokens.length != 6) {
      throw new IllegalArgumentException("당첨 번호는 6개여야합니다.");
    }

    Integer[] integers = new Integer[6];
    for (int i = 0; i < tokens.length; i++) {
      integers[i] = Integer.parseInt(tokens[i]);
    }
    return integers;
  }

  private String[] split(String carsName) {
    return carsName.replace(" ", "").split(",");
  }

}
