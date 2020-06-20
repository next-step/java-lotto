package step3;

public class LottoNumber {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private final int number;
    private boolean isBonus = false;

    LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }

    public boolean compareToNumber(LottoNumber other) {
        return this.number == other.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
