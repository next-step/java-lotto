package step02.code.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class Outcome {
  private final int money;
  private final Lottos lottos;

  public Outcome(int money, Lottos lottos){
    this.money = money;
    this.lottos = lottos;
  };

  public Map<GradeEnum, Integer> statistic(Lotto winningNumber, Number bonus) {
    return lottos.match(winningNumber, bonus).stream()
      .collect(Collectors.toMap(matched -> matched, matched -> 1, Integer::sum));
  }

  public float profit(int income) {
    return (float) income / money;
  }
}
