package step2.view;

import step2.model.Lotto;
import step2.model.LottoGame;
import step2.model.WinnerTier;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoOutput {

    private LottoOutput() {
    }

    ;

    private static final String LOTTO_NUMBER_DELEVETER = ",";

    public static void printLottoNumbers(LottoGame lottoGame) {

        List<Lotto> lottos = lottoGame.getLottos();

        for (Lotto lotto : lottos) {

            String lottoNumbers = lotto.getLottoNumbers().stream()
                    .map(i -> i.toString())
                    .collect(Collectors.joining(LOTTO_NUMBER_DELEVETER));

            System.out.printf("[%s]\n", lottoNumbers);
        }
    }

    public static void printPurchaseNumbers(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printWinningStatistics(Map<WinnerTier, Integer> winningResult, double yield) {

        for (WinnerTier winnerTier : WinnerTier.WINNINGS) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", winnerTier.getMatchCnt(), winnerTier.getPrize(), winningResult.get(winnerTier));
        }

        System.out.printf("총 수익률은 %.2f입니다.", yield);
    }
}
