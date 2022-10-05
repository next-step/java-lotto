package step02.dto;

import step02.domain.LottoGrade;

public class LottoGradeDto {

    private final int rightCount;
    private final int winnings;
    private final boolean isMustBonus;
    private final int count;

    public LottoGradeDto(int rightCount, int winnings, boolean isMustBonus, int count) {
        this.rightCount = rightCount;
        this.winnings = winnings;
        this.isMustBonus = isMustBonus;
        this.count = count;
    }

    public static LottoGradeDto of(LottoGrade lottoGrade, int count) {
        return new LottoGradeDto(lottoGrade.getRightCount(), lottoGrade.getWinnings(), lottoGrade.isMustBonus(), count);
    }

    public int getRightCount() {
        return rightCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getCount() {
        return count;
    }

    public boolean isMustBonus() {
        return isMustBonus;
    }
}
