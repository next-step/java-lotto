package lotto.domain.lotto;

import lotto.domain.*;
import lotto.domain.lotto.strategy.LottoGeneratingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;

public class Lottos {
    private static final int START_OF_RANGE = 0;

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
        if (lottos.size() == purchaseAmountOfMoney.numberOfLottoToPurchase()) {
            return;
        }

        IntStream.range(START_OF_RANGE, purchaseAmountOfMoney.numberOfLottoToPurchase())
                .forEach((i) -> lottos.add(lottoGeneratingStrategy.lotto()));
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
        return IntStream.rangeClosed(START_OF_RANGE, LOTTO_NUMBER_SIZE)
                .map(matchCount -> {
                    Rank rank = Rank.findRank(matchCount);
                    return rank.getWinningMoney() * winningStaticsArray[matchCount];
                })
                .reduce(0, Integer::sum);
    }
}
