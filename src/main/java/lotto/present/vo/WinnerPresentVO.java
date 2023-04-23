package lotto.present.vo;

import lotto.domain.Winners;

import java.util.List;

public class WinnerPresentVO {
    private final int countFifth;
    private final int countFourth;
    private final int countThird;
    private final int countFirst;
    public WinnerPresentVO(Winners winners) {
        this.countFifth = winners.getCountFifth();
        this.countFourth = winners.getCountFourth();
        this.countThird = winners.getCountThird();
        this.countFirst = winners.getCountFirst();
    }

    public int getCountFifth() {
        return this.countFifth;
    }

    public int getCountFourth() {
        return this.countFourth;
    }

    public int getCountThird() {
        return this.countThird;
    }

    public int getCountFirst() {
        return this.countFirst;
    }
}
