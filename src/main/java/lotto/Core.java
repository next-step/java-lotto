package lotto;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InPutView;
import lotto.view.OutPutView;

public class Core {

  public static void main(String[] args) {

    int amount = InPutView.getAmount();

    Integer manualCount = InPutView.getManualCount();
    List<String> manualLottoNumbers = InPutView.getManualLottoNumbers(manualCount);


    LottoStore lottoStore = new LottoStore();
    Lottos manualLottos = lottoStore.manual(manualLottoNumbers);
    Lottos autoLottos = lottoStore.auto(amount, manualLottos.size());
    OutPutView.printAutoAndManualRate(manualLottos,autoLottos);
    Lottos lottos = manualLottos.add(autoLottos);
    OutPutView.printLotto(lottos);

    String resultLottoNumbers = InPutView.getResultLottoNumbers();
    Integer bonusLottoNumber = InPutView.getBonusLottoNumber();

    LottoGame lottoGame = LottoGame.defaultOf(lottos, new WinningLotto(resultLottoNumbers, bonusLottoNumber));
    LottoResult lottoResult = lottoGame.resultWithBonusNumber();

    double profitRate = lottoResult.calculateProfitRate(amount);

    // 결과 프린트
    OutPutView.printResult(lottoResult);
    OutPutView.printProfitRate(profitRate);
  }

}
