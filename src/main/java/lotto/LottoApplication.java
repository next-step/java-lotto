package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumbers;
import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static final int LOTTO_AMOUNT = 1000;
    public static void main(String[] args) {
        int autoCount = InputView.getAutoAmount() / LOTTO_AMOUNT;
        int manualCount = InputView.getManualCount();
        if (autoCount < manualCount) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 구매금액보다 많습니다.");
        }

        InputView.removeEnter();
        InputView.printManualCommand();
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= manualCount; i++) {
            lottoNumbers.add(InputView.getManualLottoNumbers());
        }

        for (int i = 1; i <= autoCount; i++) {
            LottoNumbers generate = LottoGenerator.generate();
            lottoNumbers.add(generate);
        }

        ResultView.printCountInfo(manualCount, autoCount);
        ResultView.printLottoNumbers(lottoNumbers);
        WinnerNumbers winnerNumbers = InputView.inputWinnerNumbers();
        ResultView.printLottoResult(lottoNumbers, winnerNumbers);
    }
}
