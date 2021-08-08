package step4.lottoPlace;

import step4.validator.LottoValidator;

import java.util.List;

public class LastWeekLotto {
    private final List<Integer> lastWeekLottoNum;

    private final int bonusNum;

    protected LastWeekLotto(List<Integer> lastWeekLottoNum, int bonusNum) {
        this.lastWeekLottoNum = lastWeekLottoNum;
        this.bonusNum = bonusNum;
    }

    public static LastWeekLotto of(List<Integer> lastWeekLottoNum, int bonusNum) {
        LottoValidator.validateLottoNum(lastWeekLottoNum);
        LottoValidator.validateBonusNum(bonusNum);
        return new LastWeekLotto(lastWeekLottoNum, bonusNum);
    }

    public boolean contains(int num) {
        return this.lastWeekLottoNum.contains(num);
    }

    public boolean isBonusNumCorrect(int num) {
        return this.bonusNum == num;
    }
}
