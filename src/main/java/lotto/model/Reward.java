package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.enums.Grade;

public final class Reward {

  public static int matchCount(Set<Integer> lotteryTicket, Set<Integer> winningLotto) {
    int count = 0;
    for (int lottoNumber : lotteryTicket) {
      count = getCount(winningLotto, count, lottoNumber);
    }
    return count;
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
