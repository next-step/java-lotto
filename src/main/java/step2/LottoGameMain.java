package step2;

import step2.domain.LottoGame;
import step2.domain.LottoNumberGenerator;
import step2.domain.LottoNumbers;

import java.math.BigDecimal;

import static step2.view.InputView.inputMessageLastWeekWinningNumber;
import static step2.view.InputView.inputMessageLottoAmount;
import static step2.view.OutputView.outputMessageLottoNumbers;
import static step2.view.OutputView.outputMessageLottoResult;

public class LottoGameMain {

    public static void main(String[] args) {
        int amount = inputMessageLottoAmount();
        LottoGame lottoGame = new LottoGame(BigDecimal.valueOf(amount), new LottoNumberGenerator());
        outputMessageLottoNumbers(lottoGame.getLottoNumbers());

        String lastWinningNumber = inputMessageLastWeekWinningNumber();
        outputMessageLottoResult(amount, lottoGame.lottoResultMap(lastWinningNumber));
    }


}
