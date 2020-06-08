package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private final List<Lotto> lottoList;

  public Lottos(List<Lotto> lottoList) {
    this.lottoList = new ArrayList<>(lottoList);
  }

  public static Lottos of(Lottos quickPickedlottos, Lottos manualPickedLottos) {
    List<Lotto> mergedLottos = new ArrayList<>();

    mergedLottos.addAll(quickPickedlottos.getLottoList());
    mergedLottos.addAll(manualPickedLottos.getLottoList());

    return new Lottos(mergedLottos);
  }

  public List<Lotto> getLottoList() {
    return new ArrayList<>(lottoList);
  }

}
