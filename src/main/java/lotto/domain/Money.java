package lotto.domain;

/**
 * 돈을 의미하는 객체
 * 천원단위로 관리되기 위한 VO
 */
public class Money {
    public static final int UNIT = 1000;
    private int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < UNIT) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (value % UNIT != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 천원 단위로 입력해야 합니다.");
        }
    }

    public int value() {
        return value;
    }
}
