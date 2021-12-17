package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final Money money;
    private List<LottoNumbers> userPurchaseLottoTickets;

    public LottoStore(int money) {
        this.money = new Money(money);
        this.userPurchaseLottoTickets = new ArrayList<>();
    }

    public List<LottoNumbers> buyingLotto() {
        issueLotto(money.numberOfPurchase());
        return userPurchaseLottoTickets;
    }

    private void issueLotto(int LottoCount) {
        List<LottoNumbers> lotto = new ArrayList<>();
        for (int i = 0; i < LottoCount; i++) {
            lotto.add(LottoNumbers.createAutoLottoNumber());
        }
        userPurchaseLottoTickets = lotto;
    }
}
