package lotto.view;


import lotto.Customer;
import lotto.KLottoRank;
import lotto.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void showLottos(List<Lotto> manualLottos, List<Lotto> lottos) {
        System.out.println("수동으로 " + manualLottos.size() + "장 자동으로 " + lottos.size() + "개를 구매했습니다.");
        manualLottos.stream()
                .forEach(System.out::println);
        lottos.stream()
                .forEach(System.out::println);
    }

    public static void LottoResult(Map<KLottoRank, Integer> lottoResult, Customer customer) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        int earnMoney = 0;

        for (KLottoRank value : KLottoRank.values()) {
            int count = lottoResult.getOrDefault(value, 0);
            if (value.getBonus()) {
                System.out.println(value.getCount() + "개 일치, 보너스 볼 일치(" + value.getPrize() + ")-" + count + "개");
                earnMoney += count * value.getPrize();
                continue;
            }
            System.out.println(value.getCount() + "개 일치 (" + value.getPrize() + ")-" + count + "개");
            earnMoney += count * value.getPrize();
        }

        double rateOfReturn = (double) earnMoney / customer.getLottoMoney();

        System.out.println("총 수익률은 " + rateOfReturn + "입니다." + (rateOfReturn < 1.0 ? "기준이 1이기 때문에 결과적으로 손해라는 의미임" : ""));
    }
}
