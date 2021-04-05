package step02;

public class Main {

    public static void main(String[] args) throws Exception {
        LottoShop lottoShop = new LottoShop();

        Lottos lottos = lottoShop.buyLotto(new RandomNumberRule());
        ResultView.showBuyLottoResult(lottos);

        ResultView.showLottoWinnerResult(lottoShop.showLottoResult());
    }
}
