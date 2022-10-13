package lotto;

import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.enumeration.Rank;

import java.util.Map;

import static lotto.client.InputView.*;
import static lotto.client.OutputView.*;
import static lotto.utils.LottoCreator.getLotteries;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = scanPurchaseAmount();

        Lotteries lotteries = getLotteries(purchaseAmount);

        showCountOfLotto(lotteries);
        showCreatedLotteries(lotteries);

        Map<Rank, Long> lotteriesRank = lotteries.getLotteriesRank(new Lotto(scanLastWinLotte()), scanBonusBall());

        showResultRank(lotteriesRank);
        showReturnRate(lotteriesRank, purchaseAmount);
    }
}