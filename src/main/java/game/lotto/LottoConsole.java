package game.lotto;

import game.lotto.model.LottoGame;
import game.lotto.model.LottoNumber;
import game.lotto.model.LottoNumberFactory;
import game.lotto.model.Money;
import game.lotto.view.InputView;
import game.lotto.view.ResultView;

import java.util.Set;

public class LottoConsole {

    public static void main(String[] args) {
        Money money = InputView.readPuchaseMoney();

        LottoGame lottoGame = new LottoGame(money);

        ResultView.printAmount(lottoGame.getAmount());
        ResultView.printLottos(lottoGame.getLottos());

        String stringWinningNumbers = InputView.readWinningNumbers();
        Set<LottoNumber> winningLottoNumbers = LottoNumberFactory.createWinningLottoNumbers(stringWinningNumbers);

        //TODO 당첨 결과를 리턴받는다.
        // 로또게임의 match() 메소드 호출.
        // match() 결과로 MatchResult 반환

        //TODO 결과를 출력한다.
        // MatchResult 출력
    }

}
