package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {

    public static void buyResult(List<Lotto> lottos) {
        printBuyCount(lottos.size());
        printLottoNumbers(lottos);
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    private static void printBuyCount(int buyCount) {
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public static void printResults(List<Lotto> results) {
        // TODO: print
        //3개 일치 (5000원)- 1개
        //4개 일치 (50000원)- 0개
        //5개 일치 (1500000원)- 0개
        //6개 일치 (2000000000원)- 0개
        //총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
    }

}
