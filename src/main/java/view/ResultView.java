package view;

import domain.Lotto;

import java.util.List;

public class ResultView {

    public static void purchaseResult(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void lottoNumberResult(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.err.println(lotto.getNumbers().getValues());
        }

    }
}
