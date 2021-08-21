package step1;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class NationalNumbers {

  private final List<NationalNumber> nationalNumbers;

  public NationalNumbers(String[] numbers) {
    this.nationalNumbers = Arrays.stream(numbers)
        .map(NationalNumber::new)
        .collect(toList());
  }

  public int sum() {
    return nationalNumbers.stream()
        .map(NationalNumber::getNumber)
        .reduce(0, Integer::sum);
  }

  public int size() {
    return nationalNumbers.size();
  }
}
