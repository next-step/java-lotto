package lotto.domain;

public class LottoWinner {
    private LottoTicket winner;
    private LottoNumber bonus;

    public LottoWinner(LottoTicket winner, int bonus) {
        this.winner = winner;
        this.bonus = new LottoNumber(bonus);
    }

    public int correctWith(LottoTicket compared) {
        int result = 0;
        for (LottoNumber number : winner.getTicket()) {
            result += compared.oneIfHas(number);
        }

        return result;
    }

    public boolean hasBonus(LottoTicket ticket) {
        return ticket.oneIfHas(bonus) == 1;
    }
}
