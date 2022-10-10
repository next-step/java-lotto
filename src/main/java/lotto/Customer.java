package lotto;

public class Customer {

    private final LottoWallet lottoWallet = new LottoWallet();

    public void buy(int cashAmount) {
        int availablePurchaseLottoCount = cashAmount / LottoCompany.getLottoPrice();
        lottoWallet.generateLotto(availablePurchaseLottoCount);
    }

    public LottoWallet getLottoWallet() {
        return lottoWallet;
    }
}
