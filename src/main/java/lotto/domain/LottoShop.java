package lotto.domain;

import java.util.List;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;
    private MoneyWallet moneyWallet;
    private final LottoShopFactory lottoShopFactory;

    private LottoShop(MoneyWallet moneyWallet, LottoShopFactory lottoShopFactory) {
        this.moneyWallet = moneyWallet;
        this.lottoShopFactory = lottoShopFactory;
    }

    public static LottoShop from(MoneyWallet moneyWallet) {
        return new LottoShop(moneyWallet, new LottoShopFactory());
    }

    public LottoWallet purchase(List<List<String>> manuallyLotto) {
        List<Lotto> manuallyPurchaseLotto = lottoShopFactory.purchase(new ManuallyPurchase(manuallyLotto));
        moneyDraw(LOTTO_PRICE * manuallyPurchaseLotto.size());

        List<Lotto> autoPurchaseLotto = lottoShopFactory.purchase(new AutoPurchase(autoPurchaseCount(manuallyPurchaseLotto)));
        moneyDraw(LOTTO_PRICE * autoPurchaseLotto.size());

        manuallyPurchaseLotto.addAll(autoPurchaseLotto);
        return new LottoWallet(manuallyPurchaseLotto);
    }

    private void moneyDraw(int money) {
        moneyWallet = moneyWallet.withdraw(money);
    }

    private int autoPurchaseCount(List<Lotto> manuallyPurchaseLotto) {
        return moneyWallet.balance() / LOTTO_PRICE;
    }

}
