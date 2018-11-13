package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Ticket winningTicket;
    private int bonus;

    public WinningLotto(List<Integer> winningNumbers, int bonus) {
        this.winningTicket = new Ticket(winningNumbers);
        this.bonus = bonus;
    }

    public List<Integer> winningLottoStatus() {
        return this.winningTicket.getNumbers();
    }

    public int findBonus() {
        return this.bonus;
    }
}
