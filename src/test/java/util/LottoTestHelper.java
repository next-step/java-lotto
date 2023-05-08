package util;

import domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTestHelper {
  public static List<LottoNumber> parse(String numbers) {
    return Arrays.stream(numbers.split(","))
        .map(String::trim)
        .map(LottoNumber::new)
        .collect(Collectors.toList());
  }
}
