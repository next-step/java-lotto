package lottoAuto.view;

import lottoAuto.model.Lotto;
import lottoAuto.model.LottoNumber;
import lottoAuto.model.Lottos;
import lottoAuto.model.Rank;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

public class ResultView {
    public static void showAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void showUserLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Iterator<LottoNumber> iterator = lotto.getLottoNumbers().iterator();
            while (iterator.hasNext()) {
                LottoNumber lottoNumber = iterator.next();
                System.out.print(lottoNumber.getLottoNumber() + " ");
            }
            System.out.println();
        }
    }

    public static void showWinningStatistic(Map<Rank, Long> collect) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        collect.entrySet().stream()
                .forEach(rankLongEntry -> System.out.println(Rank.getMessage(rankLongEntry.getKey()) + " - " + rankLongEntry.getValue()));
    }

    public static void showRevenue(BigDecimal revenue) {
        System.out.println("총 수익률은 " + revenue + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
