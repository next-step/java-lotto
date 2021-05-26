package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.enterPurChaseAmount();
        Money money = new Money(inputView.nextInt());

        outputView.enterManualTicketCount();
        int manualTicketCount = inputView.nextInt();

        outputView.enterManualTicketNumbers();
        List<String> manualTicketNumbers = new ArrayList<>();
        for(int i = 0; i < manualTicketCount; i++) {
            manualTicketNumbers.add(inputView.next());
        }

        RequestedManualLottoNumbers requestedManualLottoNumbers = new RequestedManualLottoNumbers(manualTicketNumbers);

        LottoTickets lottoTickets = new LottoTickets(money, requestedManualLottoNumbers);
        outputView.printLottoTickets(lottoTickets);

        outputView.enterWinningNumbers();
        LottoNumbers winningNumbers = new LottoNumbers(inputView.next());

        outputView.enterBonusNumber();
        LottoNumber bonusNumber = new LottoNumber(inputView.nextInt());

        WinningNumbersWithBonus winningNumbersWithBonus = new WinningNumbersWithBonus(winningNumbers, bonusNumber);

        LottoStatement lottoStatement = new LottoStatement();
        lottoTickets.checkHitCount(winningNumbersWithBonus, lottoStatement);
        outputView.printStatement(lottoStatement);
        outputView.printProceedsRate(lottoTickets.calcProceedsRate(lottoStatement));
    }
}
