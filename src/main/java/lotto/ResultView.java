package lotto;

import java.util.List;

public class ResultView {

    public void printPurchaseLottoList(List<List<Integer>> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");

        for (List<Integer> lottery : lotteries) {
            System.out.println(lottery);
        }
    }
}
