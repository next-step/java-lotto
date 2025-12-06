package lotto;

import java.util.function.Supplier;

public class InputRetry {

  private InputRetry() {
  }

  public static <T> T retry(Supplier<T> action) {
    while (true) {
      try {
        return action.get();
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
