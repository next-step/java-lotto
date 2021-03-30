package lotto;

import lotto.domain.HitResults;
import lotto.domain.LottoGames;
import lotto.view.HitResultView;
import lotto.view.InputView;
import lotto.view.LottoGamesView;

public class LottoGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPayMoney();

        LottoGames lottoGames = new LottoGames(inputView.getPayMoney());
        lottoGames.makeNumbers();

        LottoGamesView lottoGamesView = new LottoGamesView(lottoGames);
        lottoGamesView.printLottoGamesNumber();

        inputView.inputHitNumbers();
        inputView.inputHitBonusNumber();
        HitResults hitResults = lottoGames.start(inputView.winNumbers());

        HitResultView hitResultView = new HitResultView(hitResults);
        hitResultView.printLottoResult();
    }
}
