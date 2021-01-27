package lotto.domain;

public enum Revenue {
    THREE_MATCHES("5000원", 3, false),
    FOUR_MATCHES("50000원", 4, false),
    FIVE_MATCHES("1500000원", 5, false),
    FIVE_AND_BONUS_MATCHES("30000000원", 5, true),
    SIX_MATCHES("2000000000원", 6, false);

    private String revenue;
    private int matchNum;
    private boolean bonus;

    Revenue(String revenue, int matchNum, boolean bonus) {
        this.revenue = revenue;
        this.matchNum = matchNum;
        this.bonus = bonus;
    }


}
