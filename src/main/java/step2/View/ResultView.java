package step2.View;

import step2.Domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public void printPurchaseNumber(PurchasedLottoNumber manualNumber, PurchasedLottoNumber autoNumber) {
        System.out.println();
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                manualNumber.getNumber(), autoNumber.getNumber()));
    }

    public void printLottoList(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
            System.out.println();
        }
    }

    private void printLotto(Lotto lotto) {
        System.out.print("[");
        String result = lotto.getLottoNumberList()
                .stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(","));
        System.out.print(result);
        System.out.print("]");
    }

    public void printLottoStatistic(Profit profit) {
        System.out.println("당첨통계");
        System.out.println("------");
        Map<LottoPrize, Integer> profitList = profit.profitList();
        for (LottoPrize rank : profitList.keySet()) {
            System.out.println(String.format("%d개 일치 (%d)원 - %d개",
                    rank.hitCount().getHit(), rank.prize(), profitList.get(rank)));
        }
    }

    public void printProfitRate(Profit profit) {
        System.out.println(String.format("총 수익률은 %.2f 입니다.", profit.profitRate()));
    }
}
