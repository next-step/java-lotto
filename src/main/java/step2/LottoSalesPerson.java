package step2;

public class LottoSalesPerson {
    private static final int LOTTO_PRICE = 1_000;
    private TheMethodOfPurchase purchase;
    private int purchasingAmount;

    public LottoSalesPerson(TheMethodOfPurchase purchase){
        this.purchase = purchase;
    }

    public int howManyBuyLotto(){
        purchase.input();
        purchasingAmount = purchase.getAmount();
        return purchasingAmount/LOTTO_PRICE;
    }
    
}
