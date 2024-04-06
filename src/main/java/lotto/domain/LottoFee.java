package lotto.domain;

public class LottoFee {

    private static final int PRICE_PER_GAME = 1000;

    private int value;

    public LottoFee(int fee) {
        validate(fee);
        this.value = fee;
    }

    private void validate(int fee) {
        validateMinPrice(fee);
        validateRemainderOccurs(fee);
    }

    private void validateRemainderOccurs(int fee) {
        if (0 < (fee % PRICE_PER_GAME)) {
            throw new IllegalArgumentException("구매 금액 단위는 1000원 입니다. 입력 금액을 확인 해주세요.");
        }
    }

    private static void validateMinPrice(int fee) {
        if (fee < PRICE_PER_GAME) {
            throw new IllegalArgumentException("한 게임당 1000원 입니다. 입력 금액을 확인 해주세요.");
        }
    }

    public static void validateManualGameCount(int manualCount, int totalCount) {
        if (manualCount > totalCount) {
            throw new IllegalArgumentException("전체 구매 게임 수 보다 수동게임 구매 숫자가 클 수 없습니다. 입력 게임수를 확인 해주세요.");
        }
    }

    public int totalCount() {
        return value/PRICE_PER_GAME;
    }

    public int getValue() {
        return value;
    }
}
