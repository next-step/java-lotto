package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        int price = InputView.lottoStart();
        Lotto lotto = new Lotto(price);
        LottoTickets lottoTickets = lottoMachine.generate(lotto.purchaseQuantity());
        OutputView.lottoQuantity(lottoTickets.lottoTicketCount());
        OutputView.lottoTickets(lottoTickets);
        String inputWinningNumber = InputView.winningNumber();
        WinningNumber winningNumber = lottoMachine.winningNumber(inputWinningNumber);
        LottoResult lottoResult = new LottoResult(lottoTickets.getLottoTickets(), winningNumber);
        OutputView.LottoEnd(lottoResult);
    }
}
