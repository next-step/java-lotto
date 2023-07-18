package edu.nextstep.camp.lotto;

import edu.nextstep.camp.lotto.controller.LottoController;
import edu.nextstep.camp.lotto.domain.AutoLottoFactory;
import edu.nextstep.camp.lotto.domain.Lottos;
import edu.nextstep.camp.lotto.view.ConsoleLottoInputView;
import edu.nextstep.camp.lotto.view.ConsoleLottoOutputView;
import edu.nextstep.camp.lotto.view.LottoView;

public class Main {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new AutoLottoFactory(), new LottoView(new ConsoleLottoInputView(), new ConsoleLottoOutputView()));

        try {
            Lottos lottos = controller.buyLottos(controller.numberOfLottoPurchases());
            controller.analysisLotto(lottos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
