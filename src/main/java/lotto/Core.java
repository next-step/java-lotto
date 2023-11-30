package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.view.InPutView;
import lotto.view.OutPutView;

public class Core {

  public static void main(String[] args) {

    int amount = InPutView.getAmount();

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.sell(amount);

    OutPutView.printLotto(lottos);

    String resultLottoNumbers = InPutView.getResultLottoNumbers();
    LottoGame lottoGame = LottoGame.defaultOf(resultLottoNumbers);
    LottoResult result = lottoGame.result(lottos);
    double profitRate = result.calculateProfitRate(amount);

    // 결과 프린트
    OutPutView.printResult(result);
    OutPutView.printProfitRate(profitRate);
  }

}
