package step2.view;

import step2.model.Lotto;
import step2.model.LottoGame;
import step2.model.WinnerTier;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoOutput {

    private LottoOutput() {};

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

        for(int i=3; i<7; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", WinnerTier.valueOf(i).getMatchCnt(), WinnerTier.valueOf(i).getPrize(), WinningResult.get(WinnerTier.valueOf(i)));
        }

        System.out.printf("총 수익률은 %.2f입니다.", Yield);
    }
}
