package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class Statistics {

  public int coincideLotto(int expectCount, List<List<Integer>> allLotto,
      List<Integer> winNumbers) {
    int result = 0;
    for (List<Integer> lotto : allLotto) {
      int count = 0;
      for (Integer winNumber : winNumbers) {
        if (lotto.contains(winNumber)) {
          count++;
        }
        if (count == expectCount) {
          result++;
          break;
        }
      }
    }
    return result;
  }

  public int winningAmount(int cost, int count) {
    return cost * count;
  }

  public double yield(int winningAmount, int haveMoney) {
    return Math.floor((double) winningAmount / haveMoney * 100)/100.0;
  }
}
