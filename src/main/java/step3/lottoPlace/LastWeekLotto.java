package step3.lottoPlace;

import java.util.List;

public class LastWeekLotto {
    private final List<Integer> lastWeekLottoNum;

    private final int bonusNum;

    protected LastWeekLotto(List<Integer> lastWeekLottoNum, int bonusNum) {
        this.lastWeekLottoNum = lastWeekLottoNum;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getLottoNums() {
        return this.lastWeekLottoNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public static LastWeekLotto of(List<Integer> lastWeekLottoNum, int bonusNum) {
        return new LastWeekLotto(lastWeekLottoNum, bonusNum);
    }
}
