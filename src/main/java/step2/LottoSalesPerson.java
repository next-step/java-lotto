package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoSalesPerson {
    private static final int LOTTO_PRICE = 1_000;
    private final TheMethodOfPurchase purchase;
    private final List<LottoTicket> lottoCollection;

    public LottoSalesPerson(TheMethodOfPurchase purchase){
        this.purchase = purchase;
        lottoCollection = new ArrayList<>();
    }

    public int howManyBuyLotto(){
        purchase.input();
        int purchasingAmount = purchase.getAmount();
        return purchasingAmount/LOTTO_PRICE;
    }

    public List<LottoTicket> makeLotto(int theNumberOfLottoTicket){
        for (int i = 0; i < theNumberOfLottoTicket; i++) {
            lottoCollection.add(new LottoTicket());
        }
        return lottoCollection;
    }
}
