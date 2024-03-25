package lotto.view;

import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.StatisticsOfLottos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Rank.MISS;

public class OutputView {
    private static final String NUMBER_OF_LOTTO_TO_PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계";
    private static final String WINNING_STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String RIGHT_SQUARE_BRACKET = "[";
    private static final String LEFT_SQUARE_BRACKET = "]";
    private static final String COMMA_BLANK = ", ";
    private static final String SEPARATOR = "---------";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final int BREAK_EVEN_POINT = 1;

    private OutputView() {
    }

    public static void printNumberOfLottoToPurchase(int numberOfManualLottoToPurchase, int totalNumberOfLottoToPurchase) {
        String numberOfLottoToPurchaseMessage = new StringBuilder()
                .append(NEXT_LINE)
                .append(String.format(NUMBER_OF_LOTTO_TO_PURCHASE_MESSAGE, numberOfManualLottoToPurchase, totalNumberOfLottoToPurchase - numberOfManualLottoToPurchase))
                .toString();

        System.out.println(numberOfLottoToPurchaseMessage);
    }

    public static void printLottos(List<Lotto> lottos) {
        StringBuilder lottosStringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            lottosStringBuilder.append(RIGHT_SQUARE_BRACKET)
                    .append(lottoNumbers(lotto))
                    .append(LEFT_SQUARE_BRACKET)
                    .append(NEXT_LINE);
        }

        System.out.println(lottosStringBuilder);
    }

    private static String lottoNumbers(Lotto lotto) {
        return lotto.lottoNumbers()
                .stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.lottoNumber()))
                .collect(Collectors.joining(COMMA_BLANK));
    }

    public static void printStatisticsOfLottos(StatisticsOfLottos statisticsOfLottos) {
        StringBuilder lottosResultBuilder = new StringBuilder();

        lottosResultBuilder.append(NEXT_LINE)
                .append(WINNING_STATISTICS_TITLE)
                .append(NEXT_LINE)
                .append(SEPARATOR)
                .append(NEXT_LINE)
                .append(winningStatisticsMessage(statisticsOfLottos))
                .append(rateOfReturnMessage(statisticsOfLottos.rateOfReturn()));

        System.out.println(lottosResultBuilder);
    }

    private static String winningStatisticsMessage(StatisticsOfLottos statisticsOfLottos) {
        StringBuilder winningStatisticsMessageBuilder = new StringBuilder();

        Arrays.stream(Rank.values())
                .filter(rank -> rank != MISS)
                .forEach(rank -> winningStatisticsMessageBuilder.append(String.format(WINNING_STATISTICS_MESSAGE, rank.matchCount(), rank.winningMoney(), statisticsOfLottos.numberOfMatchCount(rank)))
                        .append(NEXT_LINE));

        return winningStatisticsMessageBuilder.toString();
    }

    private static String rateOfReturnMessage(double rateOfReturn) {
        StringBuilder rateOfReturnMessageBuilder = new StringBuilder();

        rateOfReturnMessageBuilder.append(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
        if (BREAK_EVEN_POINT > rateOfReturn) {
            rateOfReturnMessageBuilder.append(LOSS_MESSAGE);
        }

        return rateOfReturnMessageBuilder.toString();
    }
}
