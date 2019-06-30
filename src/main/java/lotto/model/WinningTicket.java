package lotto.model;

import java.util.Objects;

public class WinningTicket {
    static final String BONUS_BALL_DUPLICATE_MESSAGE = "Bonus볼이 Ticket에 있는 숫자와 중복됩니다.";
    private Ticket ticket;
    private Ball bonus;

    public WinningTicket(Ticket ticket, Ball bonus) {
        checkDuplicate(ticket, bonus);
        this.ticket = ticket;
        this.bonus = bonus;
    }

    private void checkDuplicate(Ticket ticket, Ball bonus) {
        if (ticket.contains(bonus)) {
            throw new IllegalArgumentException(BONUS_BALL_DUPLICATE_MESSAGE);
        }
    }

    public Rank getRank(Ticket otherTicket) {
        int matchCountOfBalls = ticket.match(otherTicket);
        boolean isSameBonusBall = otherTicket.contains(bonus);

        return Rank.valueOf(matchCountOfBalls, isSameBonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningTicket)) return false;
        WinningTicket winningTicket = (WinningTicket) o;
        return ticket.equals(winningTicket.ticket) &&
                bonus.equals(winningTicket.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, bonus);
    }
}
