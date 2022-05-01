package lotto.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.LottoNumber;

public final class AwardNumberUtil {

  private AwardNumberUtil() {
  }

  private static final String DELIMITER = ", ";

  private static String[] split(String string) {
    return string.split(DELIMITER);
  }

  public static Set<LottoNumber> getAwadNumberList(String string) {
    return Arrays.stream(split(string))
        .map(Integer::parseInt)
        .map(LottoNumber::new)
        .collect(Collectors.toSet());
  }


}
