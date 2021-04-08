package step02.code.domain;

import java.util.Map;

public class ResultCalculator {
  private final int money;
  private final int total;

  public ResultCalculator(int money, int total) {
    this.money = money;
    this.total = total;
  }

  public ResultCalculator(int money) {
    this(money, 0);
  }

  public ResultCalculator calcTotal(Map<GradeEnum, Integer> result) {
    int calc = GradeEnum.sorted()
      .stream()
      .map(gradeEnum -> result.getOrDefault(gradeEnum, 0) * gradeEnum.prize())
      .reduce((total, value) -> total + value)
      .orElseThrow(() -> new IllegalArgumentException("calcTotal error"));
    return new ResultCalculator(money, calc);
  }

  public float profit() {
    return (float) total / money;
  }

}
