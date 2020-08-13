package step2;

import java.util.List;

public class Winning extends Lotto {

  private final Lotto winner;

  public Winning(List<Integer> numbers) {
    super(numbers);
    this.winner = new Lotto(numbers);
  }

  public boolean isWinner(Lotto lotto) {
    return winner.equals(lotto);
  }

  public int sameNumberCount(Lotto lotto) {
    if (isWinner(lotto)) {
      return Lotto.FIXED_COUNT;
    }

    return numbers.stream().filter(number -> lotto.hasNumber(number))
        .mapToInt(i -> 1)
        .sum();
  }
}
