package lotto;

public class LottoController {

    private final LottoShop lottoShop;

    public LottoController(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    public void startLotto() {
        lottoShop.enter();
    }
}
