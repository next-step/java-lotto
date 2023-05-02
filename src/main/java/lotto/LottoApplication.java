package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoStore;

public class LottoApplication {
    public static void main(String[] args) {
        new LottoStore(new LottoGenerator()).open(new LottoBuyer());
    }
}
