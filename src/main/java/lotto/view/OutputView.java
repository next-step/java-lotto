package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class OutputView {
    private static final int DEFAULT_SHOW_MATCH_COUNT = 0;
    private static final double RESULT_REFERENCE_RATE = 1.00D;
    private static final String LOTTO_BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_MESSAGE = "[%s]";
    private static final String WINNING_INTRO_MESSAGE = "\n당첨 통계 \n---------";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String WINNING_RATE_MESSAGE = "총 수익률은 %.2f 입니다. (%s)";

    private OutputView() {
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.number() + LOTTO_BUY_COUNT_MESSAGE);

        List<String> lottoNumbers = getLottoNumberResult(lottoTickets);
        lottoNumbers.forEach(System.out::println);
        System.out.println();
    }

    private static List<String> getLottoNumberResult(LottoTickets lottoTickets) {
        return lottoTickets.stream()
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
        LottoRank.stream()
                .filter(rank -> rank.getMatchCount() > DEFAULT_SHOW_MATCH_COUNT)
                .map(rank -> String.format(WINNING_RESULT_MESSAGE,
                        rank.getMatchCount(),
                        rank.getPrize(),
                        winningResult.getRankCount(rank)))
                .forEach(System.out::println);
    }

    private static void printLottoResultRate(WinningResult winningResult) {
        double winningRate = winningResult.calculateWinningRate();

        System.out.printf(WINNING_RATE_MESSAGE,
                winningRate,
                winningRate > RESULT_REFERENCE_RATE ? "이익" : "손해"
        );
    }
}
