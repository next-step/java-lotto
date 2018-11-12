package game.lotto;

import game.lotto.model.*;
import game.lotto.view.InputView;
import game.lotto.view.ResultView;

import java.util.Set;

public class LottoConsole {

    public static void main(String[] args) {
        Money purchaseMoney = InputView.readPurchaseMoney();

        LottoGame lottoGame = new LottoGame(purchaseMoney);
        ResultView.printAmount(lottoGame.getAmount());
        ResultView.printLottos(lottoGame.getLottos());

        String stringWinningNumbers = InputView.readWinningNumbers();
        Set<LottoNumber> winningLottoNumbers = LottoNumberFactory.createLottoNumbers(stringWinningNumbers);

        LottoNumber bonus = InputView.readBonusNumber();

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonus);

        MatchResult matchResult = lottoGame.match(winningLotto);

        ResultView.printReport(matchResult.makeReport(purchaseMoney));
    }

}
