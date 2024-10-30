package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoManager;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        List<Lotto> lottos = LottoFactory.issueLottos(InputView.input());

        LottoManager lottoManager = new LottoManager(lottos);

        ResultView.printLottos(lottoManager);
    }
}
