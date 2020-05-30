package step2.domain;

public enum Prize {
    FIRST(1, 2000000000),
    SECOND(2,1500000),
    THIRD(3,50000),
    FORTH(4,5000),
    NONE(0, 0),
    ;

    private int grade;
    private int cashPrize;

    Prize(int grade, int cashPrize) {
        this.grade = grade;
        this.cashPrize = cashPrize;
    }

    public int getGrade() {
        return grade;
    }

    public int getCashPrize() {
        return cashPrize;
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





