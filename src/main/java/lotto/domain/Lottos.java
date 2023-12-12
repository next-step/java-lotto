package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.enums.Rank;

public class Lottos {

  private final List<Lotto> lottos;

  private Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static Lottos of(List<Lotto> lottos) {
    return new Lottos(lottos);
  }

  public Lottos add(Lottos autoManual) {
    return autoManual.add(this.lottos);
  }

  private Lottos add(List<Lotto> lottos) {
    this.lottos.addAll(lottos);
    return Lottos.of(this.lottos);
  }

  public boolean sameSize(int expectSize) {
    return lottos.size() == expectSize;
  }

  public LottoResult resultWithBonusNumber(WinningLotto winningLotto) {
    Map<Rank, Lottos> result = new HashMap<>();
    for (Rank rank : Rank.values()) {
      Lottos lottos = rank.result(this, winningLotto);
      result.put(rank, lottos);
    }
    return LottoResult.defaultOf(result);
  }

  public double calculatePrice(Rank rank) {
    int count = this.lottos.size();
    return rank.calculatePrice(count);
  }

  public int size() {
    return this.lottos.size();
  }

  public List<String> toStringStatus() {

    List<String> lottoStatusList = new ArrayList<>();
    for (Lotto lotto : this.lottos) {
      String lottoStatus = lotto.toStringStatus();
      lottoStatusList.add(lottoStatus);
    }
    return lottoStatusList;
  }


  public Lottos result(WinningLotto winningLotto, Rank rank) {
    List<Lotto> result = lottos.stream()
        .filter(lotto -> Rank.valueOf(winningLotto.matchNumberCount(lotto),winningLotto.hasBonusNumber(lotto))== rank)
        .collect(Collectors.toList());
    return Lottos.of(result);
  }
}
