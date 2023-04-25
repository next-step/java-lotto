package step2.view;

import step2.domain.LottoResult;
import step2.domain.WinningMoney;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PrintView {

    private PrintView() {}

    public static void purchaseNumber(List<List<Integer>> purchaseNumber) {
        System.out.println(purchaseNumber.size() + "를 구매하셨습니다.");
        purchaseNumber.forEach(list -> {
            Collections.sort(list);
            System.out.println(list);
        });
    }

    public static void lottoResult(LottoResult result) {
        PrintView.numberOfMatches(result.numberOfMatches());
        PrintView.winningRate(result.rate());
    }

    public static void numberOfMatches(Map<Integer, Integer> numberOfMatches) {
        IntStream.rangeClosed(3, 6).forEach(i -> {
            Integer money = WinningMoney.winningMoney(i);
            Integer count = numberOfMatches.get(i);
            System.out.println(i + "개 일치 (" + money + "원):" + count);
        });
    }

    public static void winningRate(float rate) {
        System.out.println("총 수익률은" + rate + "입니다.");
    }
}
