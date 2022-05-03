package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.LottoNumber;

public final class AwardNumberUtil {


  private static final int MIN_VALUE = 1;
  private static final int MAX_VALUE = 45;

  private AwardNumberUtil() {
  }

  private static final String DELIMITER = ", ";

  public static Set<Integer> getAwadNumberList(String numberString) {
    return Arrays.stream(split(numberString))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
  }

  public static int matchCount(Set<Integer> lotteryTicket, Set<Integer> winningLotto) {
    int count = 0;
    for (int lottoNumber : lotteryTicket) {
      count = lottoMatchCount(winningLotto, count, lottoNumber);
    }
    return count;
  }

  public static List<Integer> init() {
    List<Integer> lottoNumbers = new ArrayList<>();
    for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
      lottoNumbers.add(i);
    }
    return lottoNumbers;
  }

  public static boolean getBonusCheck(Set<Integer> winningLotto, int lottoNumber) {
    return winningLotto.contains(lottoNumber);
  }

  private static int lottoMatchCount(Set<Integer> winningLotto, int count, int lottoNumber) {
    if (winningLotto.contains(lottoNumber)) {
      count++;
    }
    return count;
  }

  private static String[] split(String string) {
    return string.split(DELIMITER);
  }

}
