package lotto.view;

import lotto.entity.Lotto;
import lotto.service.LottoResultChecker;
import lotto.service.LottoSeller;

import java.util.ArrayList;
import java.util.List;

public abstract class RottoRunner {
    protected final LottoInputView inputView = new LottoInputView();
    protected final LottoResultView resultView = new LottoResultView();
    private final LottoSeller seller = new LottoSeller();
    private final LottoResultChecker resultChecker = new LottoResultChecker();

    public void run() {
        var money = inputView.inputMoney();
        var manualLottos = buyManualLotto();
        var autoLottos = seller.buyLotto(money - manualLottos.size() * LottoSeller.LOTTO_PRICE);
        printLotto(manualLottos, autoLottos);

        var winningLotto = inputView.inputWinningLotto();

        var result = resultChecker.checkResult(merge(manualLottos, autoLottos), winningLotto);
        var rateOfReturn = (double) result.getAllReward() / money;
        resultView.printResult(result, rateOfReturn);
    }

    private List<Lotto> merge(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        var result = new ArrayList<>(manualLottos);
        result.addAll(autoLottos);

        return result;
    }

    protected abstract List<Lotto> buyManualLotto();

    protected abstract void printLotto(List<Lotto> manualLottos, List<Lotto> autoLottos);

}
