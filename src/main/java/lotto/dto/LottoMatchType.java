package lotto.dto;

public enum LottoMatchType {
    THREE(3, 5_000), FOUR(4, 50_000), FIVE(5, 1_500_000), SIX(6, 2_000_000_000);
    public int matchCount;
    public int money;

    LottoMatchType(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }
}