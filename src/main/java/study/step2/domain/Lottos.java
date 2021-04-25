package study.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {

  private List<Lotto> lottos = new ArrayList<>();

  public Lottos() {
  }

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public void add(Lotto lotto) {
    this.lottos.add(lotto);
  }

  public LottoResult match(Lotto winningLotto) {
    LottoResult lottoResult = new LottoResult();

    lottos.stream().mapToInt(lotto -> lotto.matchCount(winningLotto.getLottoNumbers()))
        .mapToObj(Rank::find)
        .forEach(lottoResult::add);

    return lottoResult;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lottos lottos1 = (Lottos) o;
    return Objects.equals(lottos, lottos1.lottos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottos);
  }

}
