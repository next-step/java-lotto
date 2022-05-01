package lotto.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.LottoNumber;

public final class AwardNumberUtil {

  private AwardNumberUtil() {
  }

  private static final String DELIMITER = ", ";

  private static String[] split(String str) {
    return str.split(DELIMITER);
  }

  public static Set<LottoNumber> getAwadNumberList(String str) {
    return Arrays.stream(split(str))
        .map(Integer::parseInt)
        .map(LottoNumber::new)
        .collect(Collectors.toSet());
  }


}
