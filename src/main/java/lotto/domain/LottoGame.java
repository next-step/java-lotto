package lotto.domain;

public class LottoGame {
    private final LottoTickets lottoTickets;

    public LottoGame(FixedLottoMachine fixed, RandomLottoMachine random) {
        lottoTickets = mixedLottoTickets(generateLottoTickets(fixed), generateLottoTickets(random));
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public LottoTickets generateLottoTickets(LottoMachine lottoMachine) {
        return lottoMachine.generates();
    }

    public LottoTickets mixedLottoTickets(LottoTickets fixedLottoTickets, LottoTickets randomLottoTickets) {
        return fixedLottoTickets.union(randomLottoTickets);
    }

    public WinningNumber generateWinningNumber(String inputNumber, FixedLottoMachine fixedLottoMachine) {
        return fixedLottoMachine.generateWinningLotto(inputNumber);
    }

    public LottoNumber generateBonusBall(int inputNumber, RandomLottoMachine randomLottoMachine, WinningNumber winningNumber) {
        return randomLottoMachine.createBonusBall(inputNumber, winningNumber);
    }

    public LottoResult result(WinningNumber winningNumber, LottoNumber bonusBall) {
        return lottoTickets.createLottoResult(winningNumber, bonusBall);
    }
}
