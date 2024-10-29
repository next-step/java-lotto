package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.dto.RankResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoController controller = new LottoController();
        Lottos lottos = controller.buy(InputView.readAmount());
        OutputView.renderingLottos(lottos);

        RankResult result = controller.check(InputView.readWinningNumber(), InputView.readBonusNumber(), lottos);
        OutputView.renderingWinningStatistics(result);
    }
}
