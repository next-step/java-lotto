package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoStore;
import lotto.domain.Store;

public class LottoApplication {
    public static void main(String[] args) {
        Store store = new LottoStore();
        LottoBuyer lottoBuyer = new LottoBuyer(store);
        LottoGame lottoGame = new LottoGame(lottoBuyer);
        lottoGame.start();
    }
}
