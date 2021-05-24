package lottoAuto;

import lottoAuto.model.LottoAutoService;
import lottoAuto.model.Lotto;
import lottoAuto.model.Lottos;
import lottoAuto.view.LottoAutoResultView;

public class LottoAutoApplication {

    public static void main(String[] args) {
        LottoAutoResultView lotto = new LottoAutoResultView();
        LottoAutoService lottoAutoService = new LottoAutoService();

        int amount = lotto.showAmount();
        Lottos userLotto = lotto.showMyLottoInformation(amount);
        Lotto winningLotto = lotto.showWinningNumber();
        int bonusBall = lotto.showBonusBall();

    }
}