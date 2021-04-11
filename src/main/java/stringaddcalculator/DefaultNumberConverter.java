package stringaddcalculator;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultNumberConverter implements NumberConverter{

  @Override
  public List<Integer> convert(List<String> list) {
    return list.stream()
        .map(Integer::parseInt)
        .peek(this::validPositiveValue)
        .collect(Collectors.toList());
  }

  private void validPositiveValue(int number) {
    if(number < 0) {
      throw new NumberFormatException();
    }
  }
}
