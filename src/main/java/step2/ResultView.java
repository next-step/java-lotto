package step2;

import java.util.List;
import java.util.Set;

public class ResultView {
    public void countLottoResult(int countLotto) {
        System.out.println(countLotto + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(Set<List<Integer>> purchasedLottos) {
        for (List<Integer> purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto);
        }
        System.out.println();
    }
}
