package lotto.domain.number;

public class WinningTicket extends Ticket {

    public WinningTicket(LottoBalls winningBalls) {
        super(winningBalls);
    }

    public int countMatchBalls(Ticket ticket) {
        return (int) ticket.getLottoBalls()
                .getBalls()
                .stream()
                .filter(this.getLottoBalls()::isContain)
                .count();
    }
}
