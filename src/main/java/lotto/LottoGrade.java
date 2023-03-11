package lotto;

public enum LottoGrade {
    NO_GRADE(0, false), // 순위 외
    FIFTH(3, false), // 5등
    FOURTH(4, false), // 4등
    THIRD(5, false), // 3등
    SECOND(5, true), // 2등
    FIRST(6, false); // 1등

    private final int matchCount; // 구매한 로또와 당첨 순위를 비교했을 때, 맞힌 개수

    private final int prize; // 당첨 순위의 상금

    private boolean bouns; // 보너스 볼 당첨 여부

    /**
     * 로또 순위 생성자
     *
     * @param matchCount
     * @param bouns
     */
    LottoGrade(int matchCount, boolean bouns) {
        // 순위 권 외 일 경우, 맞힌 횟수 0으로 포기화
        if (matchCount < 3) {
            matchCount = 0;
        }
        this.matchCount = matchCount;
        this.prize = decisionPrize(matchCount, bouns);
        this.bouns = bouns;
    }

    /**
     * 당첨 순위에 따른 상금 리턴하는 함수
     *
     * @param matchCount 맞힌 개수
     * @param bouns      보너스 볼 당첨 여부
     * @return
     */
    private int decisionPrize(int matchCount, boolean bouns) {
        if (matchCount < 3) {
            return WinnerPrize.NO_GRADE_PRIZE;
        }
        if (matchCount == 3) {
            return WinnerPrize.FIFTH_PRIZE;
        }
        if (matchCount == 4) {
            return WinnerPrize.FOURTH_PRIZE;
        }
        if (matchCount == 5 && bouns) {
            return WinnerPrize.SECOND_PRIZE;
        }
        if (matchCount == 5) {
            return WinnerPrize.THIRD_PRIZE;
        }
        if (matchCount > 5) {
            return WinnerPrize.FIRST_PRIZE;
        }
        return WinnerPrize.NO_GRADE_PRIZE;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonus() {
        return bouns;
    }

}
