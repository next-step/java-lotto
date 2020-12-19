package lotto.domain;

public class LottoGame {

    public LottoTickets generateLottoTickets(LottoMachine lottoMachine) {
        return lottoMachine.generates();
    }

    public LottoTickets generateMixedLottoTickets(LottoTickets fixedLottoTickets, LottoTickets randomLottoTickets) {
        return fixedLottoTickets.union(randomLottoTickets);
    }

    public WinningNumber generateWinningNumber(String inputNumber, RandomLottoMachine randomLottoMachine) {
        return randomLottoMachine.winningNumber(inputNumber);
    }

    public LottoNumber generateBonusBall(int inputNumber, RandomLottoMachine randomLottoMachine, WinningNumber winningNumber) {
        return randomLottoMachine.CreateBonusBall(inputNumber, winningNumber);
    }

    public LottoResult result(LottoTickets lottoTickets, WinningNumber winningNumber, LottoNumber bonusBall) {
        return new LottoResult(lottoTickets.getLottoTickets(), winningNumber, bonusBall);
    }

    public int calculateRemainingMoney(int price, int manualPurchaseLottoCount) {
        return price - (manualPurchaseLottoCount * 1000);
    }
}
