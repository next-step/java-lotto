package step2.vo;

public enum LottoNumberVO {
    MIN(1), MAX(45);

    public int value;

    LottoNumberVO(int value) {
        this.value = value;
    }

    public static boolean isRange(int lottoNumber) {
        if (lottoNumber >= MIN.value && lottoNumber <= MAX.value) {
            return true;
        }
        return false;
    }
}
