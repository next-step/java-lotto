package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPurchaseLottos(List<Lotto> lottos, int manualLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "개, 자동으로 " + (lottos.size() - manualLottoCount) + "개를 구매했습니다.");
        lottos.stream().forEach(lotto -> printLottoNums(lotto));
    }

    private static void printLottoNums(Lotto lotto) {
        List<Number> sortLotto = new ArrayList<>(lotto.getNums());
        Collections.sort(sortLotto);
        System.out.println("["
                + sortLotto.stream()
                .map(number -> String.valueOf(number.getNum())).collect(Collectors.joining(", "))
                + "]");
        System.out.println();
    }

    public static void printWinningStatistics(Result result) {
        List<Rank> winningResult = result.getResult();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- "
                            + winningResult.stream().
                                filter(rank -> rank == Rank.FIFTH).count() + "개");
        System.out.println("4개 일치 (50000원)- "
                            + winningResult.stream().
                                filter(rank -> rank == Rank.FORTH).count() + "개");
        System.out.println("5개 일치 (1500000원)- "
                            + winningResult.stream().
                                filter(rank -> rank == Rank.THIRD).count() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- "
                            + winningResult.stream().
                            filter(rank -> rank == Rank.SECOND).count() + "개");
        System.out.println("6개 일치 (2000000000원)- "
                            + winningResult.stream().
                                filter(rank -> rank == Rank.FIRST).count() + "개");
    }

    public static void printWinningRatio(Result result, long purchasedPrice) {
        System.out.println("총 수익률은 " + result.getWinningRatio(purchasedPrice) + "입니다.");
    }
}
