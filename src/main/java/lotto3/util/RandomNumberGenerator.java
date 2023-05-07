package lotto3.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

  private static final Random RANDOM = new Random();
  private static final int MAX_SIZE = 6;
  private static final int MAX_NUMBER = 45;
  private static final int ONE = 1;

  public static List<Integer> generate() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < MAX_SIZE) {
      int number = RANDOM.nextInt(MAX_NUMBER) + ONE;
      addNum(numbers, number);
    }
    return numbers;
  }
  private static void addNum(List<Integer> numbers, int number) {
    if (!hasNumber(numbers, number)) {
      numbers.add(number);
    }
  }

  private static boolean hasNumber(List<Integer> numbers, int number) {
    return numbers.contains(number);
  }

}
