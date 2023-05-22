package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;

public class BonusBall {
    private final LottoNo bonusBall;

    private BonusBall(LottoNo bonusBall) {
        this.bonusBall = bonusBall;
    }

    public static BonusBall from(String bonusBall) throws TicketNumberOutOfBoundException {
        return new BonusBall(LottoNo.from(Integer.valueOf(bonusBall)));
    }

    public LottoNo getBonusBall() {
        return bonusBall;
    }
}
