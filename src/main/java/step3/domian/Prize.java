package step3.domian;

public enum Prize {
    THREE_PRIZE(3, 5_000, "3개 일치 (5000원)- "),
    FOUR_PRIZE(4, 50_000, "4개 일치 (50000원)- "),
    FIVE_PRIZE(5, 1_500_000, "5개 일치 (1500000원)- "),
    FIVE_BONUS_PRIZE(0, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)- "),
    SIX_PRIZE(6, 2_000_000_000, "6개 일치 (2000000000원)- ");

    public final int position;
    public final int prizeMoney;
    public final String text;

    Prize(int position, int prizeMoney, String text) {
        this.position = position;
        this.prizeMoney = prizeMoney;
        this.text = text;
    }
}
