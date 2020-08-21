package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class OutputView {
    private static final int DEFAULT_SHOW_MATCH_COUNT = 0;
    private static final double RESULT_REFERENCE_RATE = 1.00D;
    private static final String LOTTO_BUY_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다. \n";
    private static final String LOTTO_NUMBERS_MESSAGE = "[%s]";
    private static final String WINNING_INTRO_MESSAGE = "\n당첨 통계 \n---------";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String BONUS_WINNING_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String WINNING_RATE_MESSAGE = "총 수익률은 %.2f 입니다. (%s)";

    private OutputView() {
    }

    public static void printLottoTicketsCount(int selectBuyCount, int autoBuyCount) {
        System.out.printf(LOTTO_BUY_COUNT_MESSAGE, selectBuyCount, autoBuyCount);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        List<String> lottoNumbers = getLottoNumberResult(lottoTickets);
        lottoNumbers.forEach(System.out::println);
        System.out.println();
    }

    private static List<String> getLottoNumberResult(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets()
                .stream()
                .map(LottoTicket::getNumbers)
                .map(OutputView::makeNumbersToString)
                .collect(Collectors.toList());
    }

    private static String makeNumbersToString(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(collectingAndThen(Collectors.joining(", ")
                        , numbers -> String.format(LOTTO_NUMBERS_MESSAGE, numbers)));
    }

    public static void printLottoResult(WinningResult winningResult) {
        System.out.println(WINNING_INTRO_MESSAGE);

        printLottoResultByRank(winningResult);
        printLottoResultRate(winningResult);
    }

    private static void printLottoResultByRank(WinningResult winningResult) {
        LottoRank.getLowPrizeOrderedLottoRanks()
                .stream()
                .filter(rank -> rank.getMatchCount() > DEFAULT_SHOW_MATCH_COUNT)
                .map(rank -> makeRankResultString(rank, winningResult))
                .forEach(System.out::println);
    }

    private static String makeRankResultString(LottoRank rank, WinningResult winningResult) {
        String message = WINNING_RESULT_MESSAGE;
        if(rank.equals(LottoRank.SECOND_BONUS)) {
            message = BONUS_WINNING_RESULT_MESSAGE;
        }

        return String.format(message,
                rank.getMatchCount(),
                rank.getPrize(),
                winningResult.getRankCount(rank));
    }

    private static void printLottoResultRate(WinningResult winningResult) {
        double winningRate = winningResult.calculateWinningRate();

        System.out.printf(WINNING_RATE_MESSAGE,
                winningRate,
                winningRate > RESULT_REFERENCE_RATE ? "이익" : "손해"
        );
    }
}
