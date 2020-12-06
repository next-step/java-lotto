package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static void main(String[] args) {

        Money money = Money.from(InputView.inputPurchasePrice());

        LottoShop lottoShop = new LottoShop(new LottoAutoMachine());

        LottoTicket ticket = lottoShop.purchaseTicket(money, InputView.inputManualLottoCount());

        InputView.inputManualLottoComment();
        List<Lotto> manualLotto = new ArrayList<>();
        for (int i = 0; i < ticket.getManualQuantity(); i++) {
            manualLotto.add(Lotto.of(InputView.inputLottoNumbers()));
        }
        Lottos lottos = lottoShop.purchaseLottos(ticket, manualLotto);

        ResultView.outputPurchaseQuantity(ticket);
        ResultView.outputLottos(lottos);

        PrizeLotto prizeLotto = new PrizeLotto(Lotto.of(InputView.lastWeekLottoPrizeNumber()), InputView.inputBonusball());
        Reward reward = lottos.matchPrizeNumber(prizeLotto);

        ResultView.outputPrizeStatistics(reward);
        ResultView.outputTotalEarningRate(reward, money);

    }
}