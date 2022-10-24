package lotto;

import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.model.enumeration.Rank;

import java.util.List;
import java.util.Map;

import static lotto.client.InputView.*;
import static lotto.client.OutputView.*;
import static lotto.model.LottoCreator.createAutoLotto;
import static lotto.model.LottoCreator.createManualLotto;
import static lotto.model.Profit.getReturnRate;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = scanPurchaseAmount();
        int manualLottoCount = scanManualLottoCount();

        List<Lotto> autoLotto = createAutoLotto(purchaseAmount);
        List<Lotto> manualLotto = createManualLotto(scanManualLottoNumber(manualLottoCount));

        Lotteries lotteries = new Lotteries(autoLotto, manualLotto);

        showCountOfLotto(purchaseAmount, manualLottoCount);
        showCreatedLotteries(lotteries);

        Map<Rank, Long> lotteriesRank = lotteries.getLotteriesRank(new WinningLotto(scanLastWinLotte(), scanBonusBall()));

        showResultRank(lotteriesRank);
        showReturnRate(getReturnRate(lotteriesRank, purchaseAmount));
    }
}