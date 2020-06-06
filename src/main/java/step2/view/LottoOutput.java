package step2.view;

import step2.model.Lotto;
import step2.model.LottoGame;
import step2.model.WinnerTier;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoOutput {

    private static final String LOTTO_NUMBER_DELEVETER = ",";

    public static void printLottoNumbers(LottoGame lottoGame) {

        List<Lotto> lottos = lottoGame.getLottos();

        for (Lotto lotto : lottos) {

            String lottoNumbers = lotto.getLottonumbers().stream()
                    .sorted()
                    .map(i -> i.toString())
                    .collect(Collectors.joining(LOTTO_NUMBER_DELEVETER));

            System.out.printf("[%s]\n", lottoNumbers);
        }
    }

    public static void printPurchaseNumbers(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printWinningStatistics(Map<WinnerTier, Integer> WinningResult, double Yield) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", WinnerTier.MATCH_THREE.getMatchCnt(), WinnerTier.MATCH_THREE.getPrize(), WinningResult.get(WinnerTier.MATCH_THREE));
        System.out.printf("%d개 일치 (%d원)- %d개\n", WinnerTier.MATCH_FOUR.getMatchCnt(), WinnerTier.MATCH_FOUR.getPrize(), WinningResult.get(WinnerTier.MATCH_FOUR));
        System.out.printf("%d개 일치 (%d원)- %d개\n", WinnerTier.MATCH_FIVE.getMatchCnt(), WinnerTier.MATCH_FIVE.getPrize(), WinningResult.get(WinnerTier.MATCH_FIVE));
        System.out.printf("%d개 일치 (%d원)- %d개\n", WinnerTier.MATCH_SIX.getMatchCnt(), WinnerTier.MATCH_SIX.getPrize(), WinningResult.get(WinnerTier.MATCH_SIX));

        System.out.printf("총 수익률은 %.2f입니다.", Yield);
    }
}
