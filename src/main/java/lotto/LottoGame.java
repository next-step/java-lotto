package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public static void main(String[] args) {

        Money money = Money.from(InputView.inputPurchasePrice());

        LottoShop lottoShop = new LottoShop();

        LottoTicket ticket = lottoShop.purchaseLottoTicket(money);
        int manualCount = InputView.inputManualLottoCount();

        InputView.inputManualLottoNumbers();
        for (int i = 0; i < manualCount; i++) {
            lottoShop.exchangeManualLottos(ticket, InputView.inputLottoNumbers());
        }
        Lottos lottos = lottoShop.exchangeAutoLottos(ticket, new LottoAutoMachine());

        ResultView.outputPurchaseQuantity(ticket);
        ResultView.outputLottos(lottos);

        PrizeLotto prizeLotto = new PrizeLotto(Lotto.of(InputView.lastWeekLottoPrizeNumber()), InputView.inputBonusball());
        Reward reward = lottos.matchPrizeNumber(prizeLotto);

        ResultView.outputPrizeStatistics(reward);
        ResultView.outputTotalEarningRate(reward, money);

    }
}