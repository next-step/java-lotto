package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

  private final int lottoPrice = 1000;
  private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
  private LottoList lottoList;

  public int createLotto(int totalMoney) {
    int lottoCount = getBuyableLottoCount(totalMoney);
    List<Lotto> lottos = new ArrayList<>(lottoCount);
    for(int i = 0; i < lottoCount; i++){
      lottos.add(new Lotto(lottoNumberGenerator.generate()));
    }
    lottoList = new LottoList(lottos);
    return lottoCount;
  }

  public String getLottoResult(List<Integer> winningNumbers) {
    // TODO 구현 필요
    return null;
  }
}
