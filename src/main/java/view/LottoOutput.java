package view;

import domain.Lotto;
import domain.MyLotto;

public class LottoOutput {

    public void myLottoPrint(MyLotto myLotto) {
        for (Lotto lotto : MyLotto.getLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
