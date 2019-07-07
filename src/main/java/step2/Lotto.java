package step2;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Lotto {

    static final int LOTTO_PRICE = 1000;
    static final int WINNING_NUMBERS_LENGTH = 6;
    static final int WINNING_NUMBERS_MIN = 1;
    static final int WINNING_NUMBERS_MAX = 45;
//    private  List<List<Integer>> purchasedLotto = new ArrayList<>();

    public List<List<Integer>> generateStandardLotto(int lottoCount) {
        List<Integer> standardLotto = new ArrayList<>();
        for (int i = Lotto.WINNING_NUMBERS_MIN; i < Lotto.WINNING_NUMBERS_MAX + 1; i++) {
            standardLotto.add(i);
        }
        return generateAutoLotto(standardLotto, lottoCount);
    }

    private List<List<Integer>> generateAutoLotto(List<Integer> standardLotto, int lottoCount) {
        List<List<Integer>> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Collections.shuffle(standardLotto);
            purchasedLotto.add(standardLotto.subList(0, WINNING_NUMBERS_LENGTH));
        }
//        LottoValidationCheck.checkpurchasedLottoCount(lottoCount, purchasedLotto);
        return purchasedLotto;
    }
}
