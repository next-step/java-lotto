package lotto;

public class Main {

    public static void main(String[] args) {
        int lottoPrice = View.inputLottoPrice();
        Lottos randomLottos = Lottos.buyLotto(lottoPrice);
        int manualLottoCount = View.getManualLottoCount();
        Lottos manualLottos = View.inputManualLottos(manualLottoCount);
        View.printLottoCount(manualLottoCount, randomLottos.getLottoCount());
        Lottos lottos = manualLottos.merge(randomLottos);
        View.printLottos(lottos);
        WinningLotto winningLotto = WinningLotto.of(View.inputWinningLotto(), View.inputBonusLottoNumber());
        LottoStatistics statistics = LottoStatistics.getStatistics(lottoPrice, lottos.getResultMap(winningLotto));
        View.printLottoStatistics(statistics);
    }
}
