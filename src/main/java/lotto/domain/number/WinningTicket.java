package lotto.domain.number;

import java.util.stream.Stream;

public class WinningTicket extends Ticket {

    private final LottoBall bonusBall;

    public WinningTicket(LottoBalls winningBalls, LottoBall bonusBall) {
        super(winningBalls);
        this.bonusBall = bonusBall;
    }

    public MatchResult getMatchResult(Ticket ticket) {
        return new MatchResult(countMatch(ticket), checkBonusMatch(ticket));
    }

    private int countMatch(Ticket ticket) {
        return (int) getBallStream(ticket)
                .filter(this.getLottoBalls()::isContain)
                .count();
    }

    private boolean checkBonusMatch(Ticket ticket) {
        return getBallStream(ticket)
                .anyMatch(ball -> ball.getNumber() == bonusBall.getNumber());
    }

    private Stream<LottoBall> getBallStream(Ticket ticket) {
        return ticket.getLottoBalls()
                .getBalls()
                .stream();
    }
}
