package lotto.domain.lotto;

public class LottoNumber {

    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1-45 이내의 숫자여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        final LottoNumber lottoNumber = (LottoNumber) obj;
        return number == lottoNumber.number;
    }
}
