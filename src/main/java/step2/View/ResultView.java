package step2.View;

import step2.Domain.*;

import java.util.stream.Collectors;

public class ResultView {

    public void printPurchaseNumber(Money money) {
        System.out.println(new PurchasedLottoNumber(money).getNumber() + "개 구매했습니다.");
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
        profit.profitList().stream().forEach(System.out::println);
    }

    public void printProfitRate(Profit profit) {
        System.out.println(String.format("총 수익률은 %.2f 입니다.", profit.profitRate()));
    }
}
