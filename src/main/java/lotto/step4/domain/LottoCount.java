package lotto.step4.domain;

public class LottoCount {
    public static final int ACCEPTABLE_MIN_LOTTO_COUNT = 0;
    private final int lottoCount;

    public LottoCount(int lottoCount) {
        if (lottoCount < ACCEPTABLE_MIN_LOTTO_COUNT) {
            throw new IllegalArgumentException("음수는 올 수 없습니다.");
        }
        this.lottoCount = lottoCount;
    }

    public int createAutoCount(int money) {
        int totalCount = money / Money.LOTTO_PRICE;
        if (lottoCount > totalCount) {
            throw new IllegalArgumentException("구입 금액을 초과 하였습니다.");
        }
        return totalCount - lottoCount;
    }
}
