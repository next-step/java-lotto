package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberParser {

  private static final String DELIMITER = ",";

  public static List<LottoNumber> parse(String numberLine) {
    try {
      return Arrays.stream(numberLine.split(DELIMITER))
              .map(String::trim)
              .map(num -> new LottoNumber(Integer.parseInt(num)))
              .collect(Collectors.toList());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
    }
  }
}
