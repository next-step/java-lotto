package lotto.service;

import lotto.domain.lotto.LottoTicket;
import lotto.ui.ResultView;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private LottoMachine() {}

    public static LottoMachine turnOn(){
        return new LottoMachine();
    }

    private int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public LottoTicket purchaseLotto(int purchaseAmount) {
        int quantity = calculateLottoQuantity(purchaseAmount);
        LottoTicket lottoTicket = new LottoTicket(quantity);

        ResultView.printLottoQuantity(quantity);
        ResultView.printLottoTicket(lottoTicket);

        return lottoTicket;
    }
}
