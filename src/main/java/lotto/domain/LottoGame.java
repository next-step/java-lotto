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

        Money manualLottoMoney = Money.ofLottoCount(ioManager.inputManualLottoCount());
        List<Lotto> lottos = buyManualLottos(manualLottoMoney);

        List<Lotto> autoLottos = buyAutoLottos(money.minus(manualLottoMoney),
                                               manualLottoMoney);

        lottos.addAll(autoLottos);
        drawWinningLotto(lottos);
    }

    private List<Lotto> buyManualLottos(Money money) {

        List<List<Integer>> lottoNumbers =
            ioManager.inputManualLottoNumbers(money.getBuyableLottoSize());

        return lottoNumbers.stream()
                           .map(Lotto::of)
                           .collect(toList());
    }

    private List<Lotto> buyAutoLottos(Money remainMoney, Money manualLottoMoney) {

        ioManager.printBuyCount(manualLottoMoney.getBuyableLottoSize(),
                                remainMoney.getBuyableLottoSize());

        List<Lotto> lottos = LottoVendingMachine.defaultVendingMachine()
                                                .buyLottos(remainMoney);

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
