package lotto.step3.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class LottoStatistics {
//
//    private static final String RATE_PATTERN = "0.##";
//    private static final int LOTTO_MATCH_COUNT_START = 3;
//    private static final int LOTTO_MATCH_COUNT_END = 6;
//
//    private final Lotteries lotteries;
//    private final Lotto winningNumbers;
//    private final BonusBall bonusBall;
//
//    public LottoStatistics(Lotteries lotteries, Lotto winningNumbers, int bonusBall) {
//        this.lotteries = lotteries;
//        this.winningNumbers = winningNumbers;
//        this.bonusBall = new BonusBall(bonusBall, winningNumbers);
//    }
//
//    public Map<Integer, Integer> createRepository() {
//        Map<Integer, Integer> repository = new HashMap<>();
//        for (int count = LOTTO_MATCH_COUNT_START; count <= LOTTO_MATCH_COUNT_END; count++) {
//            repository.put(count, lotteries.totalCountOfMatch(winningNumbers, count));
//        }
//        return repository;
//    }
//
//    public boolean isSecondPrizeWinners() {
//        return lotteries.totalSecondPrizeWinners(winningNumbers, bonusBall.getBonusBall()) > 0;
//    }
//
//    public int totalSecondPrizeWinners() {
//        return lotteries.totalSecondPrizeWinners(winningNumbers, bonusBall.getBonusBall());
//    }
//
//    public double calculateRateOfProfit(int orderPrice) {
//        double totalPrizeMoney = lotteries.totalPrizeMoney(winningNumbers, bonusBall.getBonusBall());
//        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
//        format.setRoundingMode(RoundingMode.DOWN);
//        return Double.parseDouble(format.format(totalPrizeMoney / orderPrice));
//    }

}
