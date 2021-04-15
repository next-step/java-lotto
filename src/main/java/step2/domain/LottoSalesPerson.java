package step2.domain;

import step2.LottoNumberGenerator;
import step2.TheMethodOfPurchase;

public class LottoSalesPerson {
    private final TheMethodOfPurchase purchase;
    private final LottoNumberGenerator lottoNumberGenerator;
    private int purchasingAmount;

    public LottoSalesPerson(TheMethodOfPurchase purchase, LottoNumberGenerator lottoNumberGenerator){
        this.purchase = purchase;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int howManyBuyLotto(){
        purchase.input();
        purchasingAmount = purchase.getAmount();
        return purchasingAmount/LottoTicket.PRICE;
    }

    public int getPurchasingAmount(){
        return purchasingAmount;
    }

    public LottoTickets makeLotto(int theNumberOfLottoTicket){
        return new LottoTickets(theNumberOfLottoTicket, lottoNumberGenerator);
    }
}
