package step2.view;

import step2.domain.LottoResult;

import java.util.List;
import java.util.Map;

public class PrintView {

    private PrintView() {}

    public static void purchaseNumber(List<List<Integer>> purchaseNumber) {
        System.out.println(purchaseNumber.size() + "를 구매하셨습니다.");
        purchaseNumber.forEach(System.out::println);
    }

    public static void lottoResult(LottoResult result) {
        PrintView.numberOfMatches(result.numberOfMatches());
        PrintView.winningRate(result.rate());
    }

    public static void numberOfMatches(Map<Integer, Integer> numberOfMatches) {
        System.out.println("3개 일치 (5000원): " + numberOfMatches.get(3));
        System.out.println("4개 일치 (50000원): " + numberOfMatches.get(4));
        System.out.println("5개 일치 (1500000원): " + numberOfMatches.get(5));
        System.out.println("6개 일치 (2000000000원): " + numberOfMatches.get(6));
    }

    public static void winningRate(float rate) {
        System.out.println("총 수익률은" + rate + "입니다.");
    }
}
