package step4;

import step4.domain.LottoCount;
import step4.domain.LottoGame;
import step4.domain.LottoResult;
import step4.domain.generator.LottoAutoGenerator;
import step4.domain.generator.LottoManualGenerator;

import java.math.BigDecimal;

import static step4.view.InputView.*;
import static step4.view.OutputView.outputMessageLottoNumbers;
import static step4.view.OutputView.outputMessageLottoResult;

public class LottoGameMain {

    public static void main(String[] args) {
        int amount = inputMessageLottoAmount();
        int manualCount = inputMessageLottoManualCount();

        LottoGame lottoGame = new LottoGame(BigDecimal.valueOf(amount), manualCount);
        LottoCount lottoCount = lottoGame.getLottoCount();

        for (int i=0; i<lottoCount.getManualCount(); i++) {
            lottoGame.buyLotto(new LottoManualGenerator(), inputLottoManual());
        }

        for (int i=0; i<lottoCount.getAutoCount(); i++) {
            lottoGame.buyLotto(new LottoAutoGenerator());
        }

       outputMessageLottoNumbers(lottoGame);

        LottoResult lottoResult = lottoGame.lottoResultMap(inputMessageLastWeekWinningNumber(), inputMessageBonusNumber());
        outputMessageLottoResult(amount, lottoResult);
    }


}
