package lotto;

import lotto.model.Lotteries;
import lotto.model.Profit;
import lotto.model.WinningLotto;
import lotto.model.enumeration.Rank;

import java.util.Map;

import static lotto.client.InputView.*;
import static lotto.client.OutputView.*;
import static lotto.creator.LottoCreator.createAutoLotto;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = scanPurchaseAmount();
        int manualLottoCount = scanManualLottoCount();

        Lotteries lotteries = new Lotteries(createAutoLotto(purchaseAmount), scanManualLottoNumber(manualLottoCount));

        showCountOfLotto(lotteries);
        showCreatedLotteries(lotteries);

        Map<Rank, Long> lotteriesRank = lotteries.getLotteriesRank(new WinningLotto(scanLastWinLotte(), scanBonusBall()));

        showResultRank(lotteriesRank);
        showReturnRate(new Profit(lotteriesRank), purchaseAmount);
    }
}