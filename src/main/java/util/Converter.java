package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

  public static List<Integer> convertToLottoNumbers(String winningNumbers) {
    String[] numbers = winningNumbers.split(",");
    return Arrays.stream(numbers)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

}
