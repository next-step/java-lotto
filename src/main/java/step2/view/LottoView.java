package step2.view;

import java.util.List;
import step2.domain.Lotto;

public class LottoView {

    public void printLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
