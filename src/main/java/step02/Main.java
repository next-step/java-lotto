package step02;

public class Main {

    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        Lottos lottos = lottoShop.buyLotto(InputView.inputMoney(), new RandomNumberRule());
        ResultView.showLottoResult(lottos);


    }
}
