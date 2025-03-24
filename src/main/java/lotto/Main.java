package lotto;

public class Main {

    public static void main(String[] args) {
        int lottoPrice = View.inputLottoPrice();
        Lottos lottos = Lottos.buyLotto(lottoPrice);
        View.printLottoCount(lottos.getLottoCount());
    }
}
