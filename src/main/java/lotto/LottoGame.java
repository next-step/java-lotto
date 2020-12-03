package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public static void main(String[] args) {

        Money money = Money.from(InputView.inputPurchasePrice());

        LottoShop lottoShop = new LottoShop();

        lottoShop.purchaseLottoTicket(money);
        int manualCount = InputView.inputManualLottoCount();

        InputView.inputManualLottoNumbers();
        Lottos lottos = new Lottos();
        for (int i = 0; i < manualCount; i++) {
            lottos = lottoShop.exchangeManualLottos(InputView.inputLottoNumbers());
        }
        lottos = lottoShop.exchangeAutoLottos(new LottoAutoMachine());

        ResultView.outputPurchaseQuantity(lottoShop.getLottoTicket());
        ResultView.outputLottos(lottos);

        PrizeLotto prizeLotto = new PrizeLotto(Lotto.of(InputView.lastWeekLottoPrizeNumber()), InputView.inputBonusball());
        Reward reward = lottos.matchPrizeNumber(prizeLotto);

        ResultView.outputPrizeStatistics(reward);
        ResultView.outputTotalEarningRate(reward, money);

    }
}