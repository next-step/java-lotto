package step02;

public class Main {

    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();

        LottosDTO lottos = lottoShop.buyLotto(new RandomNumberRule());
        ResultView.showBuyLottoResult(lottos);

        ResultView.showLottoWinnerResult(lottoShop.showLottoResult());
    }
}
