package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int DEFAULT_SHOW_MATCH_COUNT = 0;
    private static final String LOTTO_BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_INTRO_MESSAGE = "당첨 통계 \n---------";
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
                .map(LottoTicket::stream)
                .map(OutputView::getLottoNumbersByTicket)
                .map(numbers -> "[" + numbers + "]")
                .collect(Collectors.toList());
    }

    private static String getLottoNumbersByTicket(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::valueOf)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
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
                winningRate > 100D ? "이익" : "손해"
        );
    }
}
