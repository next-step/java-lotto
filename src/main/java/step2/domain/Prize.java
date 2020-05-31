package step2.domain;

public enum Prize {
    FIRST(1, 2000000000, 6),
    SECOND(2,1500000, 5),
    THIRD(3,50000, 4),
    FORTH(4,5000, 3),
    NONE(0, 0, 0),
    ;

    private int grade;
    private int cashPrize;
    private int hitCount;

    Prize(int grade, int cashPrize, int hitCount) {
        this.grade = grade;
        this.cashPrize = cashPrize;
        this.hitCount = hitCount;
    }

    public int getGrade() {
        return grade;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public int getHitCount() {
        return hitCount;
    }

    public static int getCashPrize(int grade) {
        for (Prize prize : values()) {
            if (prize.grade == grade) {
                return prize.cashPrize;
            }
        }
        throw new IllegalArgumentException(String.valueOf(grade));
    }
}





