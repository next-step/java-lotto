package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Result;

import java.util.Arrays;;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPurchaseLottos(Lottos lottos) {
        System.out.println(lottos.getCount() + "개를 구매했습니다.");
        lottos.getLottos().stream().forEach(lotto -> printLottoNums(lotto));

    }
    private static void printLottoNums(Lotto lotto) {
        System.out.println("[" + lotto.getNums().stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]");
    }

    public static void printWinningStatistics(Result result) {
        Map<Rank, Integer> winningResult = result.getResult();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values())
                .forEach(rank -> System.out.println(rank.getMatchNums() + "개 일치 ("
                                                    + rank.getWinningMoney() + ")-"
                                                    + winningResult.get(rank) + "개"));
    }

    public static void printWinningRatio(Result result, long purchasedPrice) {
        System.out.println("총 수익률은 " + result.getWinningRatio(purchasedPrice) + "입니다.");
    }
}
