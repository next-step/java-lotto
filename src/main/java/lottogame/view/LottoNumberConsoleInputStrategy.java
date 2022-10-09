package lottogame.view;

import java.util.List;
import java.util.stream.Collectors;

import lottogame.domain.lotto.LottoNumber;
import lottogame.domain.strategy.LottoNumberGenerationStrategy;

public class LottoNumberConsoleInputStrategy implements LottoNumberGenerationStrategy {

    private final InputView inputView;

    public LottoNumberConsoleInputStrategy(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public List<LottoNumber> getNumbers() {
        return inputView.getManualLottoNumbers().stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
