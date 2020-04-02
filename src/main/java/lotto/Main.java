package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.exceptions.InvalidInputException;

public class Main {

    public static void main(String[] args) {
        try {
            Money inputMoney = Money.won(InputView.inputMoney());
            int manualCount = InputView.inputCountOfManualLottoNumber();
            Money manualLottoMoney = Money.LOTTO_PRICE.times(manualCount);
            checkEnoughMoney(manualLottoMoney, inputMoney);

            LottoTicket manualLottoTicket = InputView.inputManualLottoTicket(manualCount);
            int autoCount = inputMoney.minus(manualLottoMoney)
                    .divideToInt(Money.LOTTO_PRICE);
            LottoTicket autoLottoTicket = LottoAutoGenerator.generateAutoLottoTicket(autoCount);
            ResultView.print(manualLottoTicket, autoLottoTicket);

            LottoNumbers winningNumbers = InputView.inputWinningNumbers();
            LottoNumber bonusNumber = LottoNumber.valueOf(InputView.inputBonusNumber());
            WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.valueOf(winningNumbers, bonusNumber);

            LottoTicket lottoTicket = manualLottoTicket.merge(autoLottoTicket);
            LottoResults results = lottoTicket.collectResults(winningLottoNumbers);
            ResultView.printLottoResult(results, inputMoney);
        } catch (InvalidInputException | IllegalArgumentException e) {
            ResultView.printErrorMessage(e);
        }
    }

    private static void checkEnoughMoney( Money manualLottoMoney, Money inputMoney) {
        if (manualLottoMoney.biggerThan(inputMoney)) {
            throw new IllegalArgumentException("돈이 부족하다");
        }
    }

}
