package lottoauto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import lottoauto.model.Constant;
import lottoauto.model.Lotto;
import lottoauto.model.Lottos;
import lottoauto.model.WinningReward;

public class StatisticsService {

    private final Lottos lottos;

    public StatisticsService(Lottos lottos) {
        this.lottos = lottos;
    }

    public Map<Integer, AtomicInteger> calculateStatistics(String winningNumbers) {
        List<Integer> winningNumber = Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());

        winningNumberValidation(winningNumber);

        return compareWinningNumber(winningNumber);
    }

    private void winningNumberValidation(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자는 6개를 입력해야 합니다.");
        }
    }

    private Map<Integer, AtomicInteger> compareWinningNumber(List<Integer> winningNumber) {
        Map<Integer, AtomicInteger> winningStatistics = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            numbers.retainAll(winningNumber);
            winningStatistics.putIfAbsent(numbers.size(), new AtomicInteger());
            winningStatistics.get(numbers.size()).getAndIncrement();
        }
        return winningStatistics;
    }

    public double getRevenueRate(Map<Integer, AtomicInteger> lottoStatisticsMap) {
        double buyAmount = lottos.getSize() * Constant.ONE_LOTTO_AMOUNT;
        double summary = getSummary(lottoStatisticsMap);

        return Math.round(summary / buyAmount);
    }

    private double getSummary(Map<Integer, AtomicInteger> lottoStatisticsMap) {
        double summary = 0;
        for (int i = 3; i < 7; i++) {
            double reward = WinningReward.findRewardByMatches(i).getReward();
            double matchCount = lottoStatisticsMap.getOrDefault(i, new AtomicInteger()).intValue();

            summary += reward * matchCount;
        }
        return summary;
    }
}
