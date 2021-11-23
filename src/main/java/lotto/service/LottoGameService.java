package lotto.service;

import lotto.domain.LottoGameCount;
import lotto.view.InputView;

import java.util.Objects;

public class LottoGameService {
    private LottoGameCount lottoGameCount;

    public void startLottoGame() {
        InputView inputView = new InputView();
        inputView.inputPrice();
        lottoGameCount = inputView.getLottoGameCount();
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
