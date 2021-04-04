package step02.code.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Outcome {
  private final int money;
  private final Lottos lottos;
  private final Lotto winningNumber;
  private final Number bonus;

  public Outcome(int money, Lottos lottos, Lotto winningNumber, Number bonus){
    this.money = money;
    this.lottos = lottos;
    this.winningNumber = winningNumber;
    this.bonus = bonus;
  };

  private GradeEnum grade(Lotto lotto) {
    int matched = lotto.match(winningNumber);
    boolean isMatched = lotto.isMatchBonus(bonus);

    return GradeEnum.fromGrade(matched, isMatched);
  }

  public List<GradeEnum> match() {
    return lottos.lottos().stream()
      .map(lotto -> grade(lotto))
      .collect(Collectors.toList());
  }

  public Map<GradeEnum, Integer> statistic() {
    return match().stream()
      .collect(Collectors.toMap(matched -> matched, matched -> 1, Integer::sum));
  }

  public float profit(int income) {
    return (float) income / money;
  }
}
