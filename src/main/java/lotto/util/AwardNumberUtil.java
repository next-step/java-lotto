package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.LottoNo;

public class AwardNumberUtil {

  private static final String DELIMITER = ", ";

  private static String[] split(String str) {
    return str.split(DELIMITER);
  }

  public static Set<LottoNo> getAwadNumberList(String str) {
    return Arrays.stream(split(str))
        .map(Integer::parseInt)
        .map(LottoNo::new)
        .collect(Collectors.toSet());
  }


}
