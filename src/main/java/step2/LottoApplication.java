package step2;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        int inputMoney = View.inputMoney();
        LottoMachine lottoMachine = new LottoMachine(new LottoGenerator());

        List<Lotto> lottos = lottoMachine.buyLottos(inputMoney);
        View.printBoughtLottos(lottos);

        String rawWinningLotto = View.inputWinningLotto();
        Lotto winningLotto = lottoMachine.createWinningLotto(rawWinningLotto);

        Map<LottoResult, Integer> lottoResults = lottoMachine.getLottoResults(lottos, winningLotto);
        LottoStatistics lottoStatistics = lottoMachine.makeStatistics(inputMoney, lottoResults);

        View.printLottoStatistics(lottoStatistics);
    }
}
