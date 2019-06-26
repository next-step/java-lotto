package lotto.io;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void viewLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers().stream().map(Object::toString).collect(Collectors.joining(","))));
    }

    public static void viewResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원)- " + result.getWinningCount3());
        System.out.println("4개 일치 (50000원)- " + result.getWinningCount4());
        System.out.println("5개 일치 (1500000원)- " + result.getWinningCount5());
        System.out.println("6개 일치 (2000000000원)" + result.getWinningCount6());
    }

    public static void viewEarningRate(List<Lotto> lotto, LottoResult lottoResult) {
        int earning = 0;
        earning += lottoResult.getWinningCount6() * 2000000000;
        earning += lottoResult.getWinningCount5() * 1500000;
        earning += lottoResult.getWinningCount4() * 50000;
        earning += lottoResult.getWinningCount3() * 5000;
        System.out.println("총 수익률은" + (double) (lotto.size()) * 1000 / earning + "입니다");
    }
}
