package camp.nextstep.edu.lotto.view.console;

import camp.nextstep.edu.lotto.domain.Lotteries;
import camp.nextstep.edu.lotto.domain.RewardType;
import camp.nextstep.edu.lotto.view.ResultView;
import camp.nextstep.edu.lotto.view.console.formatter.Formatter;

import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultView {

    private static final String DELIMITER_REWARDS = "\n";
    private static final String MESSAGE_FORMAT_OF_PURCHASED_LOTTERIES = "%d개를 구매했습니다.";
    private static final String MESSAGE_FORMAT_OF_ALL_LOTTERIES_RESULT = "\n당첨 통계\n" +
            "---------\n" +
            "%s\n" +
            "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String MESSAGE_FORMAT_OF_ONE_LOTTERY_RESULT = "%d개 일치 (%d원)- %d개";

    private final Formatter<Lotteries> lotteriesFormatter;

    public ConsoleResultView(Formatter<Lotteries> lotteriesFormatter) {
        this.lotteriesFormatter = lotteriesFormatter;
    }

    @Override
    public void printPurchasedLotteries(Lotteries lotteries) {
        final String formattedMessage = String.format(MESSAGE_FORMAT_OF_PURCHASED_LOTTERIES, lotteries.size());
        final String formattedLotteries = lotteriesFormatter.format(lotteries);
        System.out.println(formattedMessage);
        System.out.println(formattedLotteries);
    }

    @Override
    public void printResults(Map<RewardType, Integer> rewardMap, double earningsRate) {
        final String formattedRewards = rewardMap.entrySet()
                .stream()
                .filter(entry -> entry.getKey() != RewardType.UNKNOWN)
                .map(entry -> {
                    final RewardType rewardType = entry.getKey();
                    final int numberOfLotteries = entry.getValue();
                    return this.formatLotteryResult(rewardType, numberOfLotteries);
                })
                .collect(Collectors.joining(DELIMITER_REWARDS));

        final String formattedResults = String.format(
                MESSAGE_FORMAT_OF_ALL_LOTTERIES_RESULT,
                formattedRewards,
                earningsRate
        );

        System.out.println(formattedResults);
    }

    private String formatLotteryResult(RewardType rewardType, int numberOfLotteries) {
        final int score = rewardType.getScore();
        final long reward = rewardType.getReward();
        return String.format(MESSAGE_FORMAT_OF_ONE_LOTTERY_RESULT, score, reward, numberOfLotteries);
    }
}
