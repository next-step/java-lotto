package lotto;

import lotto.model.Lotteries;
import lotto.model.Profit;
import lotto.model.WinningLotto;
import lotto.model.enumeration.Rank;

import java.util.Map;

import static lotto.client.InputView.*;
import static lotto.client.OutputView.*;
import static lotto.model.LottoCreator.createAutoLotto;
import static lotto.model.Profit.getReturnRate;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = scanPurchaseAmount();
        int manualLottoCount = scanManualLottoCount();

        Lotteries lotteries = new Lotteries(createAutoLotto(purchaseAmount), scanManualLottoNumber(manualLottoCount));

        showCountOfLotto(lotteries);
        showCreatedLotteries(lotteries);

        Profit profit = new Profit(new WinningLotto(scanLastWinLotte(), scanBonusBall()));

        Map<Rank, Long> lotteriesRank = profit.getLotteriesRank(lotteries.getAllLotteries());

        showResultRank(lotteriesRank);
        showReturnRate(getReturnRate(lotteriesRank, purchaseAmount));
    }
}