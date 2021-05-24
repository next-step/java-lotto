package lotto.domain;

import java.util.List;
import lotto.ui.IOManager;

import static java.util.stream.Collectors.toList;

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
        WinningLotto winningLotto = WinningLotto.of(ioManager.inputNumbers(),
                                                    ioManager.inputBonusNumber());
        printStatistics(winningLotto, lottos);
    }

    private void printStatistics(WinningLotto winningLotto, List<Lotto> lottos) {

        List<WinningType> winningTypes = lottos.stream()
                                               .map(winningLotto::getWinningType)
                                               .collect(toList());

        LottoStatistics lottoStatistics = new LottoStatistics(winningTypes);
        ioManager.printStatistics(lottoStatistics, lottos.size());
    }
}
