package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyNumbers {
  private final List<MyNumber> myNumbers;

  private MyNumbers(List<MyNumber> myNumbers) {
    this.myNumbers = myNumbers;
  }

  public static MyNumbers from(String[] numbers) {
    return new MyNumbers(
        Arrays.stream(numbers)
            .map(MyNumber::parse)
            .collect(Collectors.toList())
    );
  }

  public int addAll() {
    return myNumbers.stream()
        .mapToInt(MyNumber::getValue)
        .reduce(0, Integer::sum);
  }
}
