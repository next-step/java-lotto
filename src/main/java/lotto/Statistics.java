package lotto;

import java.util.List;

public class Statistics {

  public int coincideLotto(int expectCount, List<List<Integer>> allLotto,
      List<Integer> winNumbers) {
    int result = 0;
    for (List<Integer> lotto : allLotto) {
      int count = 0;
      for (Integer winNumber : winNumbers) {
        if(lotto.contains(winNumber)) {
          count++;
        }
        if(count == expectCount) {
          result++;
          break;
        }
      }
    }
    return result;
  }
}
