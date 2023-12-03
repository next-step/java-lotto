package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoResultType;

public class Lottos {

  private final List<Lotto> lottos;

  private Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static Lottos of(List<Lotto> lottos) {
    return new Lottos(lottos);
  }

  public boolean sameSize(int expectSize) {
    return lottos.size() == expectSize;
  }

  public LottoResult resultWithBonusNumber(Lotto resultLotto, LottoNumber bonusNumber) {
    Map<LottoResultType, Lottos> result = new HashMap<>();
    for (LottoResultType lottoResultType : LottoResultType.values()) {
      Lottos lottos = lottoResultType.result(this.lottos, resultLotto, bonusNumber);
      result.put(lottoResultType, lottos);
    }
    return LottoResult.defaultOf(result);
  }

  public double calculatePrice(LottoResultType lottoResultType) {
    int count = this.lottos.size();
    return lottoResultType.calculatePrice(count);
  }

  public int size() {
    return this.lottos.size();
  }

  public List<String> toStringStatus() {

    List<String> lottoStatusList = new ArrayList<>();
    for (Lotto lotto : this.lottos) {
      StringBuilder stringBuilder = new StringBuilder();
      String lottoStatus = stringBuilder.append(lotto.toStringStatus())
          .toString();
      lottoStatusList.add(lottoStatus);
    }
    return lottoStatusList;
  }
}
