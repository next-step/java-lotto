package lotto.domain;

import java.util.HashMap;

public class Result {

  private static HashMap<Hit, Integer> resultMap;

  public Result() {
    resultMap = new HashMap<>();
    init();
  }

  public void init() {
    for (Hit hit : Hit.values()) {
      resultMap.put(hit, 0);
    }
  }

  public void update(int hit) {
    resultMap.put(Hit.getHitCount(hit), resultMap.get(Hit.getHitCount(hit)) + 1);
  }

  public String showLotteryResult() {
    StringBuilder sb = new StringBuilder();
    for (Hit hit : Hit.all()) {
      sb.append(String.format("%s %d개\n", hit.showHitResult(), resultMap.get(hit)));
    }
    return sb.toString();
  }
}
