package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

import java.util.Map;

public class ResultView {

    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");

        lottos.getLottos().forEach(lottoNumber -> System.out.println(lottoNumber.getNumbers()));
    }

    public static void printResult(LottoResult lottoResult) {
        Map<String, Integer> map = lottoResult.getResultMap();

        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int idx = 3; idx <= 6; idx++) {
            System.out.print(idx + "개 일치 (");
            System.out.print(LottoPrize.getPrize(String.valueOf(idx)) + "원)- ");
            System.out.println(map.get(String.valueOf(idx)) + "개");
        }
        System.out.printf("총 수익률은 %.2f입니다.", lottoResult.getProfitRate());
    }
}
