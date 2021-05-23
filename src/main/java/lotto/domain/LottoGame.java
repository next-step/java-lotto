package lotto.domain;

import java.util.List;
import lotto.ui.IOManager;

public class LottoGame {

    private final IOManager ioManager;

    public LottoGame(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public static void run() {
        LottoGame lottoGame = new LottoGame(IOManager.standardIOManager());
        lottoGame.progress();
    }

    public void progress() {
        Money money = Money.of(ioManager.inputMoney());
        List<Lotto> lottos = buyLottos(money);
        drawWinningLotto(lottos);
    }

    private List<Lotto> buyLottos(Money money) {

        ioManager.printBuyCount(money.getBuyableLottoSize());

        List<Lotto> lottos = LottoVendingMachine.defaultVendingMachine()
                                                .buyLottos(money);

        for (Lotto lotto : lottos) {
            ioManager.printLine(lotto.toString());
        }

        return lottos;
    }

    private void drawWinningLotto(List<Lotto> lottos) {
        Lotto winningLotto = Lotto.of(ioManager.inputNumbers(),
                                      LottoNumber.of(ioManager.inputBonusNumber()));
        printStatistics(winningLotto, lottos);
    }

    private void printStatistics(Lotto winningLotto, List<Lotto> lottos) {
        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto, lottos);

        ioManager.printLine("당첨 통계");
        ioManager.printLine("---------");
        ioManager.printStatistics(lottoStatistics.getStatisticsData());
        ioManager.printEarningRate(lottoStatistics.getEarningsRate(lottos.size()));
    }
}
