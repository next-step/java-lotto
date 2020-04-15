package lotto.vo;

public enum LottoGrade {

    MATCHES_ALL,
    MATCHES_5,
    MATCHES_4,
    MATCHES_3,
    MATCHES_NONE;

    private static final int PRIZE_FOR_MATCHES_ALL = 2000000000;
    private static final int PRIZE_FOR_MATCHES_5 = 1500000;
    private static final int PRIZE_FOR_MATCHES_4 = 50000;
    private static final int PRIZE_FOR_MATCHES_3 = 5000;
    private static final int PRIZE_FOR_MATCHES_NONE = 0;

    public static LottoGrade fromMatchCount(int matches) {
        switch (matches) {
            case 6:
                return MATCHES_ALL;
            case 5:
                return MATCHES_5;
            case 4:
                return MATCHES_4;
            case 3:
                return MATCHES_3;
            default:
                return MATCHES_NONE;
        }
    }

    public int toMoney() {
        switch (this) {
            case MATCHES_ALL:
                return PRIZE_FOR_MATCHES_ALL;
            case MATCHES_5:
                return PRIZE_FOR_MATCHES_5;
            case MATCHES_4:
                return PRIZE_FOR_MATCHES_4;
            case MATCHES_3:
                return PRIZE_FOR_MATCHES_3;
            default:
                return PRIZE_FOR_MATCHES_NONE;
        }
    }
}
