package step4.lottoPlace;

import step4.domain.Lotto;

import java.util.List;

public class LastWeekLotto {
    private final Lotto lastWeekLottoNum;

    private final int bonusNum;

    protected LastWeekLotto(List<Integer> lastWeekLottoNum, int bonusNum) {
        this.lastWeekLottoNum = Lotto.createLotto(lastWeekLottoNum);
        this.bonusNum = bonusNum;
    }

    public static LastWeekLotto of(List<Integer> lastWeekLottoNum, int bonusNum) {
        validateBonusNum(bonusNum);
        return new LastWeekLotto(lastWeekLottoNum, bonusNum);
    }

    public boolean contains(int num) {
        return this.lastWeekLottoNum.getLottoNums().contains(num);
    }

    public boolean isBonusNumCorrect(int num) {
        return this.bonusNum == num;
    }

    private static void validateBonusNum(int bonusNum) {
        if (notInRange(bonusNum)) {
            throw new RuntimeException("로또 번호는 1 ~ 45 사이의 번호여야 합니다");
        }
    }

    private static boolean notInRange(int num) {
        return num > 45 || num <= 0;
    }
}
