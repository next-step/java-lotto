package step2.Domain;

public class PurchaseManager {

    private PurchasedLottoNumber purchasedLottoNumber;
    private Money money;

    public PurchaseManager(Money money) {
        this(new PurchasedLottoNumber(money), money);
    }

    public PurchaseManager(PurchasedLottoNumber purchasedLottoNumber, Money money) {
        this.purchasedLottoNumber = purchasedLottoNumber;
        this.money = money;
    }

    public Money money() {
        return money;
    }

    public PurchasedLottoNumber getPurchasedLottoNumber() {
        return purchasedLottoNumber;
    }
}
