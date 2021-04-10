package stringaddcalculator;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultNumberConverter implements NumberConverter{

  @Override
  public List<Integer> convert(List<String> list) {
    List<Integer> ints = list.stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    if(hasNegativeValue(ints)) {
      throw new NumberFormatException();
    }
    return ints;
  }

  private boolean hasNegativeValue(List<Integer> list) {
    return list.stream()
        .anyMatch(value -> value < 0);
  }
}
