package lotto.domain;

public enum LottoResult {
    NO_REWARD("상금이 없습니다.", 0),
    THREE_MATCHING("3개 일치 (5,000원) - ", 5000),
    FOUR_MATCHING("4개 일치 (50,000원) - ", 50000),
    FIVE_MATCHING("5개 일치 (1,500,000원) - ", 1500000),
    FIVE_MATCHING_BONUS("5개 일치, 보너스 볼 일치 (30,000,000) - ", 30000000),
    SIX_MATCHING("6개 일치 (2,000,000,000원) - ", 2000000000);

    private final String description;
    private final int reward;

    LottoResult(String description, int reward) {
        this.description = description;
        this.reward = reward;
    }
}
