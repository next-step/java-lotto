package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {

    public static void showLottos(List<Lotto> lottos){

        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers()
                    .stream()
                    .map(LottoNumber::getNum)
                    .collect(Collectors.toList()));
        }
    }

    public static void showResult(LottoGameResult lottoGameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoGameResult.getFifth() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoGameResult.getFourth() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoGameResult.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + lottoGameResult.getSecond() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoGameResult.getFirst() + "개");
        System.out.println("총 수익률은 " + lottoGameResult.getProfitRatio() + "입니다.");
    }
}
