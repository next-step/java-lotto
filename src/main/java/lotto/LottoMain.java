package lotto;


import lottoView.InputView;
import lottoView.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int gameCount = LottoGame.countGame(money);
        ResultView.resultCount(gameCount);

        List<Lotto> lottos = LottoGame.createLottoGames(gameCount);
        ResultView.printLottoNumber(lottos);

        String str = InputView.lastLottoNumbers();
        List<Integer> lastLotto = LottoGame.convertLastLottoNumbers(str);

        LottoResult lottoResult = LottoGame.lottoResult(money, lottos, lastLotto);
        ResultView.printLottoResult(lottoResult);
    }

}
