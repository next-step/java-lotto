package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBoard;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.enums.Rank;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PURCHASE_MSG = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String NEWLINE_CHARACTER = "\n";
    private static final String FRONT_BRACKETS = "[";
    private static final String END_BRACKETS = "]";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String BOUNDARY = "---------";
    private static final String WINNING_MATCH_MSG = "%d개 일치 (%d)원 - %d개";
    private static final String WINNING_RATIO = "총 수익률은 %.02f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {
    }

    public static void printPurchaseAmount(LottoBuyer lottoBuyer, List<String> lottoList) {
        System.out.println(String.format(PURCHASE_MSG, lottoList.size(), lottoBuyer.getLottoQuantity() - lottoList.size()));
    }

    public static void printLottos(Lottos lottos) {
        String lottoList = lottos.stream()
                .map(ResultView::lottoToString)
                .collect(Collectors.joining());

        System.out.println(lottoList);
    }

    private static String lottoToString(Lotto lotto) {
        return FRONT_BRACKETS + lotto.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER))
                + END_BRACKETS + NEWLINE_CHARACTER;
    }

    public static void printLottoResult(LottoBoard lottoBoard) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(BOUNDARY);

        Map<Rank, Integer> board = lottoBoard.getBoard();

        Rank.getLottoBoardMatcher().forEach(i -> {
            System.out.println(String.format(WINNING_MATCH_MSG, i.getMatchCount(), i.getWinningBonus(), board.get(i)));
        });

        System.out.println(String.format(WINNING_RATIO, lottoBoard.getWinningRatio()));
    }
}
