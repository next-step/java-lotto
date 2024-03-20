package lotto.model;

import lotto.view.InputView;

import java.util.List;

public class ManualPurchaseStrategy implements LottoStrategy {

    private final InputView inputView;

    public ManualPurchaseStrategy(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public List<Lotto> execute(int quantity) {
        return inputView.askManualLotto(quantity);
    }
}
