package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Numbers {

  private final Queue<Integer> numbers;
  private static final String NUMBER_REGEX = "^[0-9]*$";

  public Numbers(List<String> numbers) {
    validateNumber(numbers);
    this.numbers = convertToIntegerQueue(numbers);
  }

  public Numbers(String ...numbers) {
    this(List.of(numbers));
  }

  private void validateNumber(List<String> numbers) {
    for(String number : numbers){
      checkNumericValue(number);
    }
  }

  private void checkNumericValue(String number) {
    if(!number.matches(NUMBER_REGEX)){
      throw new IllegalArgumentException("숫자가 아닌 값이 있습니다.");
    }
  }

  private Queue<Integer> convertToIntegerQueue(List<String> numbers) {
    Queue<Integer> parsedNumbers = new LinkedList<>();
    numbers.forEach(number -> parsedNumbers.add(Integer.parseInt(number)));
    return parsedNumbers;
  }


  public boolean isEmpty() {
    return numbers.isEmpty();
  }

  public Integer nextValue() {
    return numbers.poll();
  }
}
