package lottoController;


import lottoModel.Lotto;
import lottoModel.LottoResult;
import lottoView.InputView;
import lottoView.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int gameCount = LottoDomain.countGame(money);
        ResultView.resultCount(gameCount);

        List<Lotto> lottos = LottoDomain.createLottoGames(gameCount);
        ResultView.printLottoNumber(lottos);

        String str = InputView.lastLottoNumbers();
        Set<Integer> lastLotto = LottoDomain.convertLastLottoNumbers(str);

        LottoResult lottoResult = LottoDomain.lottoResult(money, lottos, new ArrayList<>(lastLotto));
        ResultView.printLottoResult(lottoResult);
    }

}
