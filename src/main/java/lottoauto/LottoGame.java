package lottoauto;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.enterPurChaseAmount();
        LottoGenerateStrategy autoStrategy = new AutoStrategy();
        LottoTickets lottoTickets = new LottoTickets(new Money(inputView.nextInt()), autoStrategy);
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
