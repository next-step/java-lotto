package step02;

import step02.dto.LottosDTO;
import step02.model.lotto.LottoShop;
import step02.model.numberRule.RandomNumberRule;
import step02.ui.ResultView;

public class Main {

    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();

        LottosDTO lottos = lottoShop.buyLotto(new RandomNumberRule());
        ResultView.showBuyLottoResult(lottos);

        ResultView.showLottoWinnerResult(lottoShop.showLottoResult());
    }
}
