package lotto;

import java.util.List;
import lotto.config.LottoFactory;
import lotto.controller.LottoController;
import lotto.dto.LottosDto;
import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();

        InputView inputView = lottoFactory.inputView();
        long cost = inputView.moneyToBuyLotto();

        LottoController controller = lottoFactory.lottoController();
        LottosDto lottosDto = controller.buyLottos(cost);
        List<Integer> winnerLotto = inputView.winnerLottoNumbers();
        controller.informRankStatistics(lottosDto, winnerLotto, cost);
    }
}
