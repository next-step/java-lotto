package lotto.domain.lotto;

import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;

public class Lottos {
    private static final int START_OF_RANGE = 0;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos valueOf(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public ResultOfLottos result(WinningNumbers winningNumbers, PurchaseAmountOfMoney purchaseAmountOfMoney) {
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
