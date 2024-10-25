package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoStore store = new LottoStore();
        List<Lotto> lottos = store.buy(InputView.readAmount());
        OutputView.renderingLottos(lottos);
    }
}
