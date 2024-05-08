public class LottoNumber {
    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (!(value >= 1 && value <= 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 이내만 허용합니다 : " + value);
        }
    }

    public int get() {
        return this.value;
    }
}
