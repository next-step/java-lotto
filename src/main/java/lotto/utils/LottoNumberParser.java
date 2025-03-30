package lotto.utils;

import lotto.domain.LottoNumber;

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
      throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
    }
  }
}
