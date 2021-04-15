package step2;

public class LottoSalesPerson {
    private static final int LOTTO_PRICE = 1_000;
    private final TheMethodOfPurchase purchase;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoSalesPerson(TheMethodOfPurchase purchase, LottoNumberGenerator lottoNumberGenerator){
        this.purchase = purchase;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int howManyBuyLotto(){
        purchase.input();
        int purchasingAmount = purchase.getAmount();
        return purchasingAmount/LOTTO_PRICE;
    }

    public LottoTickets makeLotto(int theNumberOfLottoTicket){
        return new LottoTickets(theNumberOfLottoTicket, lottoNumberGenerator);
    }
}
