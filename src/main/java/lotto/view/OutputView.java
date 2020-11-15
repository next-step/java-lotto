package lotto.view;

import lotto.domain.lotto.Lottos;
import lotto.dto.LottoStatisticsResult;
import lotto.dto.RewardCountAndPrizeMoney;
import lotto.dto.WinLotteryResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DELIMITER = "," + ViewString.SPACE;

    public static void printLottoCount(final Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printAllLotto(final Lottos lottos) {
        lottos.getAllLottoNumber().forEach(OutputView::printLottoNumber);
        Printer.print(ViewString.NEWLINE);
    }

    private static void printLottoNumber(final List<Integer> lottoNumbers) {
        final String view = "["
                + lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER))
                + "]"
                + ViewString.NEWLINE;
        Printer.print(view);
    }

    public static void printStatistics(final LottoStatisticsResult lottoStatisticsResult) {
        final String view = ViewString.NEWLINE + "당첨 통계" + ViewString.NEWLINE + "---------" + ViewString.NEWLINE;
        Printer.print(view);
        printWinLottery(lottoStatisticsResult.getWinLotteryResult());
        printProfit(lottoStatisticsResult);
    }

    public static void printWinLottery(final WinLotteryResult winLotteryResult) {
        printRewardCountAndPrizeMoney(winLotteryResult.getFifthRank());
        printRewardCountAndPrizeMoney(winLotteryResult.getFourthRank());
        printRewardCountAndPrizeMoney(winLotteryResult.getThirdRank());
        printRewardCountAndPrizeMoney(winLotteryResult.getSecondRank(), true);
        printRewardCountAndPrizeMoney(winLotteryResult.getFirstRank());
    }

    public static void printRewardCountAndPrizeMoney(final RewardCountAndPrizeMoney rewardCountAndPrizeMoney) {
        printRewardCountAndPrizeMoney(rewardCountAndPrizeMoney, false);
    }

    public static void printRewardCountAndPrizeMoney(final RewardCountAndPrizeMoney rewardCountAndPrizeMoney, final boolean announceBonus) {
        final StringBuilder builder = new StringBuilder(rewardCountAndPrizeMoney.getHitTimes() + "개 일치");

        if (announceBonus) {
            builder.append(DELIMITER + "보너스 볼 일치");
        }

        builder.append("(" +
                rewardCountAndPrizeMoney.getPrizeMoney() + "원" +
                ")" +
                "- " +
                rewardCountAndPrizeMoney.getCount() + "개" + ViewString.NEWLINE);
        Printer.print(builder.toString());
    }

    public static void printProfit(final LottoStatisticsResult lottoStatisticsResult) {
        final String view = "총 수익률은 " + lottoStatisticsResult.getProfitRate() + "입니다.";
        Printer.print(view);
    }
}
