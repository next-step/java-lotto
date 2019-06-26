package lotto;

import lotto.domain.Lotto;
import lotto.view.LottoIO;

public class LottoRunner {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.start(new LottoIO());
    }
}
