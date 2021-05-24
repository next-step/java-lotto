package lottoAuto;

import lottoAuto.model.LottoAuto;
import lottoAuto.model.LottoStatistic;
import lottoAuto.model.Lotto;
import lottoAuto.model.Lottos;
import lottoAuto.view.LottoAutoResultView;

public class LottoAutoApplication {

    public static void main(String[] args) {
        LottoAutoResultView lottoView = new LottoAutoResultView();
        int amount = lottoView.showAmount();

        LottoAuto lottoAuto = new LottoAuto();
        Lottos userLotto = lottoAuto.inputUserLottoNumber(amount);
        lottoView.showUserLotto(userLotto);

        String winningLottoString = lottoView.showWinningNumber();
        Lotto winningLotto = lottoAuto.inputWinningNumber(winningLottoString);

        int bonusBall = lottoView.showBonusBall();

    }
}