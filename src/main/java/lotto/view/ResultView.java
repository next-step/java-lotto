package lotto.view;

import lotto.controller.response.LottosDto;
import lotto.domain.*;

import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASED_LOTTOS_NUMBER_NOTICE = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String RESULT_STATISTIC_NOTICE = "\n당첨 통계\n---------\n";
    private static final String LOTTO_NUMBER_FORMAT = "[%s]\n";
    private static final String RESULT_RANK_FORMAT = "%d개 일치 (%d원)- %d개\n";
    private static final String RESULT_SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String RESULT_YIELD_LOSE_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";
    private static final String RESULT_YIELD_WIN_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)\n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final int YIELD_PROFIT_CONDITION = 1;

    public static void printLottos(LottosDto lottosDto) {
        StringBuffer stringBuffer = new StringBuffer(
                String.format(PURCHASED_LOTTOS_NUMBER_NOTICE,
                        lottosDto.manualLottoCount(),
                        lottosDto.autoLottoCount())
        );

        stringBuffer.append(generateLottosFormat(lottosDto.getManualLottos()));
        stringBuffer.append(generateLottosFormat(lottosDto.getAutoLottos()));

        System.out.println(stringBuffer.toString());
    }

    public static String generateLottosFormat(Set<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(generateLottoFormat(lotto));
        }

        return stringBuilder.toString();
    }

    public static String generateLottoFormat(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();

        String joinedNumbers = lotto.getLottoNumbers().stream()
                .map(num -> Integer.toString(LottoNumber.valueOf(num)))
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
        stringBuilder.append(String.format(LOTTO_NUMBER_FORMAT, joinedNumbers));

        return stringBuilder.toString();
    }

    public static void printLottoResult(MatchResult result, int paidMoney) {
        StringBuilder stringBuilder = new StringBuilder(RESULT_STATISTIC_NOTICE);
        int winningPrice = 0;

        for (Rank rank : Rank.winValues()) {
            int matchCount = result.getOrDefault(rank);
            stringBuilder.append(generateRankResultFormat(rank, matchCount));

            winningPrice += rank.calculatePrice(matchCount);
        }
        stringBuilder.append(getYieldResult((float) winningPrice / (float) paidMoney));

        System.out.println(stringBuilder.toString());
    }

    private static String generateRankResultFormat(Rank rank, int matchCount) {
        String format = RESULT_RANK_FORMAT;

        if (rank == Rank.SECOND) {
            format = RESULT_SECOND_RANK_FORMAT;
        }

        return String.format(format, rank.getMatchCount(), rank.getWinningPrice(), matchCount);
    }

    private static String getYieldResult(float yield) {
        if (isProfit(yield)) {
            return String.format(RESULT_YIELD_WIN_FORMAT, yield);
        }

        return String.format(RESULT_YIELD_LOSE_FORMAT, yield);
    }

    private static boolean isProfit(float yield) {
        return yield > YIELD_PROFIT_CONDITION;
    }
}
