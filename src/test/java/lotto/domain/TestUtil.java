package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtil {

  private TestUtil() {}

  static List<LottoNumber> toNumbers(String numbersString) {
    return Arrays.stream(numbersString.split(","))
        .map(numberString -> new LottoNumber(Integer.parseInt(numberString)))
        .collect(Collectors.toList());
  }
}
