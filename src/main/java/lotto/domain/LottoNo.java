package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;

public class LottoNo {
    int number;

    private LottoNo(int number) throws TicketNumberOutOfBoundException {
        if (checkValid(number)) {
            this.number = number;
        }
    }

    public static LottoNo from(int number) throws TicketNumberOutOfBoundException {
        return new LottoNo(number);
    }

    private boolean checkValid(int number) throws TicketNumberOutOfBoundException {
        if (number < 0 || number > 45) {
            throw new TicketNumberOutOfBoundException("1 ~ 45 범위만 입력 가능합니다.");
        }
        return true;
    }

    public int number() {
        return this.number;
    }

    public boolean equals(LottoNo lottoNo) {
        return this.number == lottoNo.number();
    }
}
