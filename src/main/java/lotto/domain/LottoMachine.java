package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoTicket;

    public List<Lotto> purchaseLotto(int purchaseAmount) {
        int quantity = calculateLottoQuantity(purchaseAmount);
        lottoTicket = createLotto(quantity);
        for(Lotto lotto : lottoTicket){
            System.out.println(lotto.getLottoNumber());

        }
        return lottoTicket;
    }

    private List<Lotto> createLotto(int quantity) {
        lottoTicket = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTicket.add(Lotto.create());
        }
        return lottoTicket;
    }

    private int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

}
