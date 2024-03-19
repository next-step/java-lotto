package lotto.domain.lotto;

import lotto.domain.*;
import lotto.domain.lotto.strategy.LottoGeneratingStrategy;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;

public class Lottos {
    private final PurchaseAmountOfMoney purchaseAmountOfMoney;
    private final List<Lotto> lottos;

    private Lottos(PurchaseAmountOfMoney purchaseAmountOfMoney) {
        this.purchaseAmountOfMoney = purchaseAmountOfMoney;
        this.lottos = new ArrayList<>();
    }

    public static Lottos valueOf(PurchaseAmountOfMoney purchaseAmountOfMoney) {
        return new Lottos(purchaseAmountOfMoney);
    }

    public void purchaseLotto(LottoGeneratingStrategy lottoGeneratingStrategy) {
        for (int i = 0; i < purchaseAmountOfMoney.numberOfLottoToPurchase(); i++) {
            lottos.add(lottoGeneratingStrategy.lotto());
        }
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public ResultOfLottos result(WinningNumbers winningNumbers) {
        int[] winningStaticsArray = winningStaticsArray(winningNumbers);
        double rateOfReturn = purchaseAmountOfMoney.rateOfReturn(winningMoney(winningStaticsArray));

        return ResultOfLottos.newLottoResult(winningStaticsArray, rateOfReturn);
    }

    private int[] winningStaticsArray(WinningNumbers winningNumbers) {
        int[] winningStaticsArray = new int[LOTTO_NUMBER_SIZE + 1];

        for (Lotto lotto : lottos) {
            winningStaticsArray[lotto.countOfMatch(winningNumbers)]++;
        }

        return winningStaticsArray;
    }

    private int winningMoney(int[] winningStaticsArray) {
        int winningMoney = 0;

        for (int matchCount = 0; matchCount <= LOTTO_NUMBER_SIZE; matchCount++) {
            Rank rank = Rank.findRank(matchCount);
            winningMoney += (rank.getWinningMoney() * winningStaticsArray[matchCount]);
        }

        return winningMoney;
    }
}
