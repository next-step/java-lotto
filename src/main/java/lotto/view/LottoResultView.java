package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class LottoResultView {

    private LottoResultView() {

    }

    public static void printBuyLottoNumber(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.print("[");
            List<Integer> numbers = lotto.retrieveNumbers();
            for (int i = 0; i < numbers.size() - 1; i++) {
                System.out.print(numbers.get(i) + ", ");
            }
            System.out.println(numbers.get(numbers.size() - 1) + "]");
        }
    }
}
