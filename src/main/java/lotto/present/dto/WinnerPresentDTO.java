package lotto.present.dto;

import lotto.domain.Statics;

public class WinnerPresentDTO {
    private final int countFifth;
    private final int countFourth;
    private final int countThird;
    private final int countSecond;
    private final int countFirst;


    public WinnerPresentDTO(Statics statics) {
        this.countFifth = statics.getCountFifth();
        this.countFourth = statics.getCountFourth();
        this.countThird = statics.getCountThird();
        this.countSecond = statics.getCountSecond();
        this.countFirst = statics.getCountFirst();
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

    public int getCountSecond() {
        return this.countSecond;
    }
}
