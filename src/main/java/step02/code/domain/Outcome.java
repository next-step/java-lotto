package step02.code.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Outcome {
  private final int money;
  private final Lottos lottos;
  private final Lotto winningNumber;

  public Outcome(int money, Lottos lottos, Lotto winningNumber){
    this.money = money;
    this.lottos = lottos;
    this.winningNumber = winningNumber;
  };

  public List<Integer> match(List<Number> winningNumber) {
    return lottos.lottos().stream()
      .map(lotto -> lotto.match(winningNumber))
      .collect(Collectors.toList());
  }

  public Map<Integer, Integer> statistic() {
    return match(winningNumber.lotto())
      .stream()
      .collect(Collectors.toMap(matched -> matched, matched -> 1, Integer::sum));
  }

  public float profit(int income) {
    return (float) income / money;
  }
}
