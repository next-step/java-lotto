package study.lotto.view;

import study.lotto.domain.LottoRank;
import study.lotto.domain.LottoResult;
import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;

import java.util.stream.Collectors;

public class ResultView {
    private static String BUY_MESSAGE = "개를 구매했습니다.";
    private static String RESULT_MESSAGE = "당첨 통계";
    private static String SEPARATOR = "---------";
    private static String MATCH_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static String MATCH_MESSAGE_WITH_BONUS =
            "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static String RATE_OF_RETURN_MESSAGE = "총 수익률은 %f입니다.";
    private static String RATE_OF_RETURN_ADDITIONAL_MESSAGE =
            "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";


    public static void displayBuyingLotto(Lottos lottos) {
        System.out.println(lottos.size() + BUY_MESSAGE);
        for (Lotto lotto : lottos) {
            displayLottoTicket(lotto);
        }
    }

    public static void displayResult(LottoResult lottoResult) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(SEPARATOR);
        displayWinningList(lottoResult);
        displayRateOfReturn(lottoResult.getRateOfReturn());
    }

    private static void displayLottoTicket(Lotto lotto) {
        System.out.print("[");
        String numbers = lotto.getLottoNumbers().stream()
                .map(number -> Integer.toString(number.getNumber()))
                .collect(Collectors.joining(", "));
        System.out.print(numbers);
        System.out.println("]");
    }

    private static void displayWinningList(LottoResult lottoResult) {
        LottoRank[] lottoRanks = LottoRank.values();
        for (int i = lottoRanks.length - 1; i >= 0; i--) {
            LottoRank lottoRank = lottoRanks[i];
            Lottos winningTickets =
                    lottoResult.getWinningLottos(lottoRank);
            displayWinning(lottoRank, winningTickets.size());
        }
    }

    private static void displayWinning(LottoRank lottoRank, int count) {
        if (lottoRank.equals(LottoRank.MISS)) {
            return;
        }
        if (lottoRank.isMatchBonus()) {
            System.out.println(String.format(MATCH_MESSAGE_WITH_BONUS,
                    lottoRank.getMatchCount(), lottoRank.getPrize(), count));
            return;
        }
        System.out.println(String.format(MATCH_MESSAGE,
                lottoRank.getMatchCount(), lottoRank.getPrize(), count));
    }

    private static void displayRateOfReturn(double rateOfReturn) {
        System.out.print(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
        if (rateOfReturn < 1) {
            System.out.println(RATE_OF_RETURN_ADDITIONAL_MESSAGE);
        }
    }
}
