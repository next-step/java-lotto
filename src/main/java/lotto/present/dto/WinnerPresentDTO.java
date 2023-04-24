package lotto.present.dto;

import lotto.domain.Winners;

public class WinnerPresentDTO {
    private final int countFifth;
    private final int countFourth;
    private final int countThird;
    private final int countFirst;
    public WinnerPresentDTO(Winners winners) {
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
