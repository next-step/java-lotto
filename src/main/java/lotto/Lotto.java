package lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {

  private final List<Integer> pickedNumbers;

  public Lotto() {
    this.pickedNumbers = this.pickNumbers();
  }

  private static List<Integer> pickNumbers() {
    return new Random().ints(1, 46)
            .distinct()
            .limit(6)
            .boxed()
            .collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return pickedNumbers.toString();
  }
}
