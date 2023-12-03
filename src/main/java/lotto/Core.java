package lotto;

import lotto.domain.LottoGame;
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
    Integer bonusLottoNumber = InPutView.getBonusLottoNumber();

    LottoGame lottoGame = LottoGame.defaultOf(lottos, resultLottoNumbers, bonusLottoNumber);
    LottoResult result = lottoGame.resultWithBonusNumber();

    double profitRate = result.calculateProfitRate(amount);

    // 결과 프린트
    OutPutView.printResult(result);
    OutPutView.printProfitRate(profitRate);
  }

}
