package lotto;

public class LottoNumber {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(Integer number) {
        this.number = number;
    }

    public LottoNumber(int number) {
        this.number = validateNumberRange(number);
    }
    public LottoNumber(String number) {
        if (!isDigit(number)) {
            throw new IllegalArgumentException(String.format("%s는 숫자가 아닙니다.", number));
        }
        this.number = validateNumberRange(Integer.parseInt(number));
    }

    private boolean isDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private int validateNumberRange(int number) {
        if (inValidNumberRange(number)) {
            throw new IllegalArgumentException(String.format("%d는 로또 숫자 범위(%d ~ %d)를 벗어났습니다.", number, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
        return number;
    }

    private boolean inValidNumberRange(int number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
