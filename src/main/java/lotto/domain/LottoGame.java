package lotto.domain;

public class LottoGame {

    public LottoTickets generateLottoTickets(int price, LottoMachine lottoMachine) {
        return lottoMachine.generate(price);
    }

    public WinningNumber generateWinningNumber(String inputNumber, LottoMachine lottoMachine) {
        return lottoMachine.winningNumber(inputNumber);
    }

    public LottoNumber generateBonusBall(int inputNumber, LottoMachine lottoMachine, WinningNumber winningNumber) {
        return lottoMachine.bonusBall(inputNumber, winningNumber);
    }

    public LottoResult result(LottoTickets lottoTickets, WinningNumber winningNumber, LottoNumber bonusBall) {
        return new LottoResult(lottoTickets.getLottoTickets(), winningNumber, bonusBall);
    }
}
