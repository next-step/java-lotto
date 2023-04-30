package domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator implements RandomNumberStrategy {

  private static Random random = new Random();

  @Override
  public List<Integer> generate() {
    List<Integer> numbers = new ArrayList<>();
    while (numbers.size() < 6) {
      int number = random.nextInt(45) + 1;
      addNum(numbers, number);
    }
    Collections.shuffle(numbers);
    return numbers;
  }

  private static void addNum(List<Integer> numbers, int number) {
    if (!numbers.contains(number)) {
      numbers.add(number);
    }
  }
}
