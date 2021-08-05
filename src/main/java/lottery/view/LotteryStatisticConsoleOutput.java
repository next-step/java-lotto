package lottery.view;

import lottery.dto.LotteryResultDto;
import lottery.dto.LotteryStatisticDto;

import java.text.DecimalFormat;
import java.util.stream.Collectors;

public class LotteryStatisticConsoleOutput {

    private static final String TITLE = "\n당첨 통계\n---------\n";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public void printLotteryStatistic(final LotteryStatisticDto lotteryStatisticDto) {
        System.out.println(getLotteryStatisticAsString(lotteryStatisticDto));
    }

    private String getLotteryStatisticAsString(final LotteryStatisticDto lotteryStatisticDto) {
        return lotteryStatisticDto.getLotteryResultDtos()
                .stream()
                .map(this::getLotteryResultsAsString)
                .collect(Collectors.joining("\n", TITLE, getEarningsRateAsString(lotteryStatisticDto)));
    }

    private String getEarningsRateAsString(final LotteryStatisticDto lotteryStatistic) {
        return "\n총 수익률은 "
                + DECIMAL_FORMAT.format(lotteryStatistic.getEarningsRate())
                + "입니다.";
    }

    private String getLotteryResultsAsString(final LotteryResultDto lotteryResult) {
        return lotteryResult.getExplanation()
                + "(" + lotteryResult.getCashPrize() + "원)- "
                + lotteryResult.getCount() + "개";
    }
}
