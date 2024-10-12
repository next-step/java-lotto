package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getLottoNumbers();
        System.out.println(numbers.toString());
    }

    public static void printPurchaseQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }
}
