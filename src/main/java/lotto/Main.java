package lotto;

public class Main {

    public static void main(String[] args) {
        int lottoPrice = View.inputLottoPrice();
        Lottos lottos = Lottos.buyLotto(lottoPrice);
        View.printLottoCount(lottos.getLottoCount());
        View.printLottos(lottos);
        Lotto winningLotto = View.inputWinningLotto();
        LottoStatistics statistics = LottoStatistics.getStatistics(lottoPrice, lottos.getResultMap(winningLotto));
        View.printLottoStatistics(statistics);
    }
}
