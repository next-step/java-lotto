package lotto.domain;

import java.util.HashMap;
import lotto.constant.Constant;

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

  public Integer getResult(Hit hit) {
    return resultMap.get(hit);
  }

  public double getRatio(Amount amount) {
    double profit = getProfit();
    return calcRatio(profit, amount.getPrice());
  }

  private double calcRatio(double profit, int price) {
    return (profit / price);
  }

  private double getProfit() {
    double profit = 0;
    for (Hit hit : Hit.all()) {
      profit += resultMap.get(hit) * hit.prize();
    }
    return profit;
  }

  public boolean isProfit(double ratio) {
    return ratio >= Constant.STANDARD_OF_PROFIT;
  }
}
