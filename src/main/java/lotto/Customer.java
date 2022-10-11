package lotto;

public class Customer {

    private final LottoWallet lottoWallet = new LottoWallet();

    public int purchase(int cashAmount) {
        int availablePurchaseLottoCount = LottoCompany.getAvailablePurchaseLottoCount(cashAmount);
        lottoWallet.generateLotto(availablePurchaseLottoCount);

        return availablePurchaseLottoCount;
    }

    public LottoWallet getLottoWallet() {
        return lottoWallet;
    }
}
