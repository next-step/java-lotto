package lottoauto;

import java.util.List;

public class User {
    private final int amountForPurchasingLotto;

    public User(int amountForPurchasingLotto) {
        this.amountForPurchasingLotto = amountForPurchasingLotto;
    }

    public int amountForPurchasingLotto() {
        return amountForPurchasingLotto;
    }

    public List<LottoTicket> buyLottoTickets(LottoStore lottoStore) {
        return lottoStore.giveLottoTickets(amountForPurchasingLotto);
    }
}
