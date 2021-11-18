package lotto.step3.service;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.Store;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private static final String RATE_PATTERN = "0.##";
    private static final int LOTTO_RANK_START = 3;
    private static final int LOTTO_RANK_END = 6;

    public Lotteries buyLotteries(int orderPrice) {
        Store store = new Store(orderPrice);
        return store.sellLotteries();
    }

    public Lotto createWinningNumbers(List<Integer> winningNumber) {
        return new Lotto(winningNumber);
    }

    public Map<Integer, Integer> totalCountOfMatch(Lotteries lotteries, Lotto winningNumbers) {
        Map<Integer, Integer> eachOfCount = new HashMap<>();
        for (int count = LOTTO_RANK_START; count <= LOTTO_RANK_END; count++) {
            eachOfCount.put(count, lotteries.totalCountOfMatch(winningNumbers, count));
        }
        return eachOfCount;
    }

    public boolean isSecondPrizeWinners(Lotteries lotteries, Lotto winningNumbers, int bonusBall) {
        return lotteries.isSecondPrizeWinners(winningNumbers, bonusBall);
    }

    public int totalSecondPrizeWinners(Lotteries lotteries, Lotto winningNumbers, int bonusBall) {
        return lotteries.totalSecondPrizeWinners(winningNumbers, bonusBall);
    }

    public double calculateRateOfProfit(Lotteries lotteries, Lotto winningNumbers, int bonusBall, int orderPrice) {
        double totalPrizeMoney = lotteries.totalPrizeMoney(winningNumbers, bonusBall);
        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(format.format(totalPrizeMoney / orderPrice));
    }

    public void validation(Lotto lotteries, int bonusBall) {
        boolean isSame = lotteries.getNumbers().stream()
                .anyMatch(number -> number == bonusBall);
        if (!isSame) {
            throw new IllegalArgumentException();
        }
    }

}
