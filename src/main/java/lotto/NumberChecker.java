package lotto;

public class NumberChecker {
    private LottoTicket winnerNumbers;

    public NumberChecker(LottoTicket winner) {
        this.winnerNumbers = winner;
    }

    public int correct(LottoTicket ticket) {
        return winnerNumbers.correctWith(ticket);
    }
}
