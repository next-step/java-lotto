package lotto.service;

import lotto.domain.LottoGameCount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Objects;

public class LottoGameService {
    private LottoGameCount lottoGameCount;
    private InputView inputView;
    private OutputView outputView;

    public void startLottoGame() {
        inputView = new InputView();
        outputView = new OutputView();
        inputView.inputPrice();
        lottoGameCount = inputView.getLottoGameCount();
        outputView.drawLottoGameCount(lottoGameCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGameService that = (LottoGameService) o;
        return Objects.equals(lottoGameCount, that.lottoGameCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGameCount);
    }
}
