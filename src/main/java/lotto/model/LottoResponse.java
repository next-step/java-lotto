package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.enums.Grade;

public class LottoResponse {

  private final Set<Lotto> lottos;
  private final Grade grade;

  public LottoResponse(Set<Lotto> lottos, Grade grade) {
    this.lottos = lottos;
    this.grade = grade;
  }

  public long count() {
    return lottos.stream()
        .filter(g -> g.currentGrade() != Grade.NONE)
        .filter(g -> g.currentGrade() == grade)
        .count();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoResponse that = (LottoResponse) o;
    return Objects.equals(lottos, that.lottos) && grade == that.grade;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottos, grade);
  }
}
