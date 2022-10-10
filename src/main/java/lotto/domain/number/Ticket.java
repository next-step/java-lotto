package lotto.domain.number;

import lotto.domain.exception.NullLottoBallsListException;

public class Ticket {

    private final LottoBalls lottoBalls;

    public Ticket(LottoBalls lottoBalls) {
        if (lottoBalls == null) {
            throw new NullLottoBallsListException();
        }

        this.lottoBalls = lottoBalls;
    }

    public LottoBalls getLottoBalls() {
        return lottoBalls;
    }
}
