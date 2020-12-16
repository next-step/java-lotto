package step4;

import step4.domain.LottoGame;
import step4.domain.LottoResult;
import step4.domain.generator.LottoAutoGenerator;

import java.math.BigDecimal;

import static step4.view.InputView.*;
import static step4.view.OutputView.outputMessageLottoNumbers;
import static step4.view.OutputView.outputMessageLottoResult;

public class LottoGameMain {

    public static void main(String[] args) {
        int amount = inputMessageLottoAmount();
        LottoGame lottoGame = new LottoGame(BigDecimal.valueOf(amount), new LottoAutoGenerator());
        outputMessageLottoNumbers(lottoGame.getLottoNumbers());

        LottoResult lottoResult = lottoGame.lottoResultMap(inputMessageLastWeekWinningNumber(), inputMessageBonusNumber());
        outputMessageLottoResult(amount, lottoResult);
    }


}
