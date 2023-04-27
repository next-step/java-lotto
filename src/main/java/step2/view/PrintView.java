package step2.view;

import step2.domain.LottoResult;
import step2.domain.Match;
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

    public static void numberOfMatches(Map<Match, Integer> numberOfMatches) {
        System.out.println("3개 일치 (5000원) - " + numberOfMatches.get(new Match(3, false)) + "개");
        System.out.println("4개 일치 (50000원) - " + numberOfMatches.get(new Match(4, false)) + "개");
        System.out.println("5개 일치 (1500000원) - " + numberOfMatches.get(new Match(5, false)) + "개");
        System.out.println("5개 일치 (30000000원) - " + numberOfMatches.get(new Match(5, true)) + "개");
        System.out.println("6개 일치 (2000000000원) - " + numberOfMatches.get(new Match(6, false)) + "개");
    }

    public static void winningRate(float rate) {
        System.out.println("총 수익률은" + rate + "입니다.");
    }
}
