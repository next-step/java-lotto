package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Numbers {

  private final Queue<Integer> numbers;
  private static final String NUMBER_REGEX = "^[0-9]*$";

  public Numbers(List<String> numbers) {
    validateNumber(numbers);
    this.numbers = parseInt(numbers);
  }

  public Numbers(String ...numbers) {
    List<String> nums = List.of(numbers);
    validateNumber(nums);
    this.numbers = parseInt(nums);
  }

  private void validateNumber(List<String> numbers) {
    numbers.stream()
        .filter(number -> !number.matches(NUMBER_REGEX))
        .findAny()
        .ifPresent(number -> {
          throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.\"");
        });
  }

  private Queue<Integer> parseInt(List<String> numbers) {
    Queue<Integer> parsedNumbers = new LinkedList<>();
    numbers.forEach(number -> parsedNumbers.add(Integer.parseInt(number)));
    return parsedNumbers;
  }


  public boolean isEmpty() {
    return numbers.isEmpty();
  }

  public Integer poll() {
    return numbers.poll();
  }
}
