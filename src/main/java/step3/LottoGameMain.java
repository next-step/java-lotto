package step3;

import step3.domain.LottoGame;
import step3.domain.LottoNumberGenerator;

import java.math.BigDecimal;

import static step3.view.InputView.inputMessageLastWeekWinningNumber;
import static step3.view.InputView.inputMessageLottoAmount;
import static step3.view.OutputView.outputMessageLottoNumbers;
import static step3.view.OutputView.outputMessageLottoResult;

public class LottoGameMain {

    public static void main(String[] args) {
        int amount = inputMessageLottoAmount();
        LottoGame lottoGame = new LottoGame(BigDecimal.valueOf(amount), new LottoNumberGenerator());
        outputMessageLottoNumbers(lottoGame.getLottoNumbers());

        String lastWinningNumber = inputMessageLastWeekWinningNumber();
        outputMessageLottoResult(amount, lottoGame.lottoResultMap(lastWinningNumber));
    }


}
