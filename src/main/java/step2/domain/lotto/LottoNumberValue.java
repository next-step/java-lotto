package step2.domain.lotto;

public enum LottoNumberValue {
    MIN(1), MAX(45);

    public int value;

    LottoNumberValue(int value) {
        this.value = value;
    }

    public static boolean isRange(int lottoNumber) {
        if (lottoNumber >= MIN.value && lottoNumber <= MAX.value) {
            return true;
        }
        return false;
    }
}
