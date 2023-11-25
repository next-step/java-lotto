package lotto.controller;

import lotto.model.*;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoApplication {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    public LottoApplication(LottoInput lottoInput, LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void run() {
        LottoFactory lottoFactory = new LottoFactory(lottoInput.getInput(), lottoInput.getManualLottoCount());
        TotalLottos totalLottos = lottoFactory.generateLottos(lottoInput.getManualLottoNumbers(lottoFactory));

        lottoOutput.viewManualAndAutoCount(lottoFactory);
        lottoOutput.viewLottosDetail(totalLottos);

        WinnerNumbers winnerNumbers = new WinnerNumbers(lottoInput.getWinningNumber(), lottoInput.getBonusBall());
        Lottery lottery = new Lottery(winnerNumbers, totalLottos);

        lottoOutput.viewCorrectLottos(lottery);
        lottoOutput.viewTotalIncomeRatio(lottery);
    }

}
