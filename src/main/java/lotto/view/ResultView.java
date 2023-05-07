package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class ResultView {

    public static void printLottoNumber() {
        for (LottoNumber lotto : Lotto.lotto) {
            System.out.println(lotto);
        }
    }

}
