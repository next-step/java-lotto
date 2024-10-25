package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.dto.RankResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoController controller = new LottoController();
        List<Lotto> lottos = controller.buy(InputView.readAmount());
        OutputView.renderingLottos(lottos);

        RankResult result = controller.check(InputView.readWinningNumber(), lottos);
        OutputView.renderingWinningStatistics(result);
    }
}
