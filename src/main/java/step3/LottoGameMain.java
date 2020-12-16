package step3;

import step3.domain.LottoGame;
import step3.domain.generator.LottoAutoGenerator;
import step3.domain.LottoResult;

import java.math.BigDecimal;

import static step3.view.InputView.*;
import static step3.view.OutputView.outputMessageLottoNumbers;
import static step3.view.OutputView.outputMessageLottoResult;

public class LottoGameMain {

    public static void main(String[] args) {
        int amount = inputMessageLottoAmount();
        LottoGame lottoGame = new LottoGame(BigDecimal.valueOf(amount), new LottoAutoGenerator());
        outputMessageLottoNumbers(lottoGame.getLottoNumbers());

        LottoResult lottoResult = lottoGame.lottoResultMap(inputMessageLastWeekWinningNumber(), inputMessageBonusNumber());
        outputMessageLottoResult(amount, lottoResult);
    }


}
