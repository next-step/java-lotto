package lotto.domain;

public class LottoGame {

    public LottoGame() {
    }

    public LottoTickets generateLottoTickets(int price, LottoMachine lottoMachine) {
        return lottoMachine.generate(price);
    }

    public WinningNumber generateWinningNumber(String inputNumber, LottoMachine lottoMachine) {
        return lottoMachine.winningNumber(inputNumber);
    }

    public LottoResult result(LottoTickets lottoTickets, WinningNumber winningNumber) {
        return new LottoResult(lottoTickets.getLottoTickets(), winningNumber);
    }
}
