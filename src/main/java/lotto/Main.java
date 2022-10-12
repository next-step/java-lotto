package lotto;

import lotto.model.Lotteries;
import lotto.model.LottoMachine;
import lotto.model.enumeration.Rank;

import java.util.Map;

import static lotto.client.InputView.*;
import static lotto.client.OutputView.*;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = scanPurchaseAmount();

        Lotteries lotteries = new Lotteries(new LottoMachine(), purchaseAmount);

        showCountOfLotto(lotteries);
        showCreatedLotteries(lotteries);

        Map<Rank, Long> lotteriesRank = lotteries.getLotteriesRank(scanLastWinLotte(), scanBonusBall());

        showResultRank(lotteriesRank);
        showReturnRate(lotteries, lotteriesRank, purchaseAmount);
    }
}