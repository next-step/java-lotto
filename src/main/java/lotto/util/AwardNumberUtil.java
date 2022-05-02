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

  public static Set<Integer> getAwadNumberList(String string) {
    return Arrays.stream(split(string))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
  }

  public static int matchCount(Set<Integer> lotteryTicket, Set<Integer> winningLotto) {
    int count = 0;
    for (int lottoNumber : lotteryTicket) {
      count = getCount(winningLotto, count, lottoNumber);
    }
    return count;
  }

  public static List<Integer> init() {
    List<Integer> lottoNumbers = new ArrayList<>();
    for (int i = MIN_VALUE; i < MAX_VALUE; i++) {
      lottoNumbers.add(i);
    }
    return lottoNumbers;
  }

  private static String[] split(String string) {
    return string.split(DELIMITER);
  }

  private static int getCount(Set<Integer> winningLotto, int count, int lottoNumber) {
    for (int winningNumber : winningLotto) {
      count = numberMatch(lottoNumber, count, winningNumber);
    }
    return count;
  }

  private static int numberMatch(int lottoNumber, int count, int winningNumber) {
    if (lottoNumber == winningNumber) {
      count++;
    }
    return count;
  }


}
