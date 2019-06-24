package camp.nextstep.edu.lotto.view;

import camp.nextstep.edu.lotto.domain.Lottery;
import camp.nextstep.edu.lotto.domain.RewardType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultView {

    private static final String MESSAGE_FORMAT_OF_PURCHASED_LOTTERIES = "%d개를 구매했습니다.";
    private static final String PREFIX_LOTTERY = "[";
    private static final String POSTFIX_LOTTERY = "]";
    private static final String DELIMITER_LOTTERY = ", ";
    private static final String DELIMITER_LOTTERIES = "\n";
    private static final String MESSAGE_FORMAT_OF_ALL_LOTTERIES_RESULT = "\n당첨 통계\n" +
            "---------\n" +
            "%s\n" +
            "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String MESSAGE_FORMAT_OF_ONE_LOTTERY_RESULT = "%d개 일치 (%d원)- %d개";

    @Override
    public void printPurchasedLotteries(List<Lottery> lotteries) {
        final String formattedMessage = String.format(MESSAGE_FORMAT_OF_PURCHASED_LOTTERIES, lotteries.size());
        final String formattedLotteries = lotteries.stream()
                .map(this::formatLottery)
                .collect(Collectors.joining(DELIMITER_LOTTERIES));
        System.out.println(formattedMessage);
        System.out.println(formattedLotteries);
    }

    private String formatLottery(Lottery lottery) {
        return lottery.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER_LOTTERY, PREFIX_LOTTERY, POSTFIX_LOTTERY));
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
                .collect(Collectors.joining("\n"));

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
