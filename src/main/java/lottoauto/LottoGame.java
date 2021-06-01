package lottoauto;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.enterPurChaseAmount();
        Money money = new Money(inputView.nextInt());

        int manualTicketCount = outputView.enterManualTicketCount(inputView);
        List<String> manualTicketNumbers = outputView.enterManualTicketNumbers(manualTicketCount, inputView);

        LottoCounter lottoCounter = new LottoCounter(money, manualTicketCount);
        LottoTickets lottoTickets = lottoCounter.generateLottoTickets(manualTicketNumbers);

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
