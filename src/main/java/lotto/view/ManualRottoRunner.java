package lotto.view;

import lotto.entity.Lotto;

import java.util.List;

public class ManualRottoRunner extends RottoRunner {

    @Override
    protected List<Lotto> buyManualLotto() {
        return inputView.inputManualLotto();
    }

    @Override
    protected void printLotto(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        resultView.printLottos(manualLottos, autoLottos);
    }
}
