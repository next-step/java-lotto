package lotto.view;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 23:10
 */
public class LottoResultView {

    public static void printLotto(List<List<Integer>> purchasedLotto) {
        purchasedLotto.forEach(System.out::println);
    }
}
