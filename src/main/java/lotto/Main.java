package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        Money inputMoney = Money.won(InputView.inputMoney());
        LottoTicket lottoTicket = LottoGenerator.generateLottoTicket(inputMoney);
        ResultView.print(lottoTicket);

        String inputWinningNumbers = InputView.inputWinningNumbers();
        LottoNumbers winningNumbers = LottoNumbers.valueOf(inputWinningNumbers.split(ResultView.LOTTO_NUM_DELIMITER));
        LottoNumber bonusNumber = LottoNumber.valueOf(InputView.inputBonusNumber());

        LottoResults results = lottoTicket.collectResults(winningNumbers, bonusNumber);
        ResultView.printLottoResult(results, inputMoney);
    }

}
