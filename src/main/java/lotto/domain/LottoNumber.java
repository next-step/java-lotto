package lotto.domain;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int value;

    public LottoNumber(int value) {
        assertNumberInRange(value);
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    private void assertNumberInRange(int value) {
        if (value < MIN || MAX < value) {
            throw new IllegalArgumentException("로또는 1부터 45까지의 숫자만 선택할 수 있습니다.");
        }
    }

}
