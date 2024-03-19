package lotto.view;

import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.ResultOfLottos;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;

public class OutputView {
    private static final String NUMBER_OF_LOTTO_TO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계";
    private static final String WINNING_STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String RIGHT_SQUARE_BRACKET = "[";
    private static final String LEFT_SQUARE_BRACKET = "]";
    private static final String COMMA_BLANK = ", ";
    private static final String SEPARATOR = "---------";
    private static final String NEXT_LINE = "\n";

    private OutputView() {
    }

    public static void printNumberOfLottoToPurchase(int numberOfLottoToPurchase) {
        String numberOfLottoToPurchaseMessage = String.format(NUMBER_OF_LOTTO_TO_PURCHASE_MESSAGE, numberOfLottoToPurchase);
        System.out.println(numberOfLottoToPurchaseMessage);
    }

    public static void printLottos(List<Lotto> lottos) {
        StringBuilder lottosStringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            lottosStringBuilder.append(RIGHT_SQUARE_BRACKET)
                    .append(lotto.lottoNumbers().stream()
                            .map(number -> Integer.toString(number))
                            .collect(Collectors.joining(COMMA_BLANK)))
                    .append(LEFT_SQUARE_BRACKET)
                    .append(NEXT_LINE);
        }

        System.out.println(lottosStringBuilder);
    }

    public static void printResultOfLottos(ResultOfLottos resultOfLottos) {
        StringBuilder lottosResultBuilder = new StringBuilder();

        lottosResultBuilder.append(NEXT_LINE)
                .append(WINNING_STATISTICS_TITLE)
                .append(NEXT_LINE)
                .append(SEPARATOR)
                .append(NEXT_LINE)
                .append(getWinningStatisticsMessage(resultOfLottos))
                .append(rateOfReturnMessage(resultOfLottos.rateOfReturn()));

        System.out.println(lottosResultBuilder);
    }

    private static String getWinningStatisticsMessage(ResultOfLottos resultOfLottos) {
        StringBuilder winningStatisticsMessageBuilder = new StringBuilder();

        for (int matchCount = FOURTH.getMatchCount(); matchCount <= FIRST.getMatchCount(); matchCount++) {
            Rank rank = Rank.findRank(matchCount);
            winningStatisticsMessageBuilder.append(String.format(WINNING_STATISTICS_MESSAGE, rank.getMatchCount(), rank.getWinningMoney(), resultOfLottos.winningStatic(rank.getMatchCount())))
                    .append(NEXT_LINE);
        }

        return winningStatisticsMessageBuilder.toString();
    }

    private static String rateOfReturnMessage(double rateOfReturn) {
        StringBuilder rateOfReturnMessageBuilder = new StringBuilder();

        rateOfReturnMessageBuilder.append(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
        if (1 > rateOfReturn) {
            rateOfReturnMessageBuilder.append(LOSS_MESSAGE);
        }

        return rateOfReturnMessageBuilder.toString();
    }
}
