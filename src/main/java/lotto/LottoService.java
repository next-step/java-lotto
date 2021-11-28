package lotto;

import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoService {
    void playLotto() {
        InputView inputView = new InputView();
        Lottos lottos = inputView.getLottos();
    }
}
