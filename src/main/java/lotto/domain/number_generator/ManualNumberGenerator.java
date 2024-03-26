package lotto.domain.number_generator;

import lotto.view.InputView;

import java.util.List;

public class ManualNumberGenerator implements NumberGenerateStrategy {

    private final InputView inputView;

    public ManualNumberGenerator(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public List<Integer> generate() {
        return inputView.getLottoNumbers();
    }
}
