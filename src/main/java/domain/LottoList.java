package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {

  private List<Lotto> lottos;

  public LottoList(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public List<List<Integer>> getLottoNumbers() {
    return lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList());
  }

}
