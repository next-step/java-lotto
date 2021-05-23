package lotto.enums;

public enum Payout {
    MATCH_ZERO(0, 0),
    MATCH_ONE(1, 0),
    MATCH_TWO(2, 0),
    MATCH_THREE(3, 5_000),
    MATCH_FOUR(4, 50_000),
    MATCH_FIVE(5, 1_500_000),
    MATCH_SIX(6, 2_000_000_000);

    private int matchNumber;
    private int payout;

    Payout(int matchNumber, int payout) {
        this.matchNumber = matchNumber;
        this.payout = payout;
    }

    public int getPayout() {
        return this.payout;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    //TODO 피드백 : 람다식으로 변경
    public static int getPayout(int matchNumber) {
        for (Payout payout : Payout.values()) {
            if (payout.getMatchNumber() == matchNumber) {
                return payout.getPayout();
            }
        }
        throw new IllegalArgumentException("0에서 6까지의 숫자를 넣어주세요");
    }
}
