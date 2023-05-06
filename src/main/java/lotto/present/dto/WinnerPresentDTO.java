package lotto.present.dto;

import lotto.domain.Prize;
import lotto.domain.Statics;

public class WinnerPresentDTO {
    private final int countFifth;
    private final int countFourth;
    private final int countThird;
    private final int countSecond;
    private final int countFirst;


    public WinnerPresentDTO(Statics statics) {
        this.countFifth = statics.countPrize(Prize.FIFTH);
        this.countFourth = statics.countPrize(Prize.FOURTH);
        this.countThird = statics.countPrize(Prize.THIRD);
        this.countSecond = statics.countPrize(Prize.SECOND);
        this.countFirst = statics.countPrize(Prize.FIRST);
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
