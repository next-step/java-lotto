package step02.code.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Lottos {
  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public List<Lotto> lottos() {
    return Collections.unmodifiableList(lottos);
  }

  public List<GradeEnum> match(Lotto winningNumber, Number bonus) {
    return lottos.stream()
      .map(lotto -> GradeEnum.fromGrade(lotto.match(winningNumber), lotto.isMatchBonus(bonus)))
      .collect(Collectors.toList());
  }

}