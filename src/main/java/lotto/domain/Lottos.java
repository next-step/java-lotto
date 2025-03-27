package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

  private final List<Lotto> lottoList;

  public Lottos(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public int getCount() {
    return lottoList.size();
  }

  public void printAllLottos() {
    lottoList.forEach(lotto -> System.out.println(lotto.getNumberRepresentation()));
  }

  public List<Integer> countMatchingNumbers(WinningLotto winningLotto) {
    return lottoList.stream().map(
        lotto -> lotto.countMatchingNumbers(winningLotto)
    ).collect(Collectors.toList());
  }

  public List<Boolean> countMatchingBonus(WinningLotto winningLotto) {
    return lottoList.stream().map(
            winningLotto::hasBonus
    ).collect(Collectors.toList());
  }
}
