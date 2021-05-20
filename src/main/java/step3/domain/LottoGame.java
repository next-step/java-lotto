package step3.domain;

import java.util.List;
import step3.ui.IOManager;

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
            ioManager.printLint(lotto.toString());
        }

        return lottos;
    }

    private void drawWinningLotto(List<Lotto> lottos) {

        ioManager.printLint("지난 주 당첨 번호를 입력해주세요.");
        Lotto winningLotto = Lotto.of(ioManager.inputNumbers());

        LottoStatistics lottoStatistics = new LottoStatistics(winningLotto);
        List<String> statistics = lottoStatistics.getStatistics(lottos);
        ioManager.printMultiLine(statistics);
    }
}
