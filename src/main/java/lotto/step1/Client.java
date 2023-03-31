package lotto.step1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final Wallet wallet = new Wallet(); // 사용자가 로또를 저장할 지갑

    //사용자가 로또를 구매하는 함수
    public void purchase(int money) {
        List<Lotto> lottos = LottoOrg.purchase(money);
        wallet.addLottos(lottos);
    }

    //사용자 지갑을 반환하는 함수
    public Wallet getWallet() {
        return wallet;
    }
}
