package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final Wallet wallet = new Wallet(); // 사용자가 로또를 저장할 지갑

    /**
     * 사용자가 로또를 구매하는 함수
     *
     * @param money 금액
     */
    public void purchase(int money) {
        List<Lotto> lottos = LottoOrganizer.purchase(money);
        wallet.addLottos(lottos);
    }

    /**
     * 사용자 지갑을 반환하는 함수
     *
     * @return wallet
     */
    public Wallet getWallet() {
        return wallet;
    }
}
