package lotto;

import lotto.domain.Lotto;
import lotto.view.LottoIO;

public class LottoRunner {
    public static void main(String[] args) {
        LottoIO io = new LottoIO();
        Lotto lotto = new Lotto(io.getNumOfPurchased());
        lotto.start(io);
    }
}
