package step3.domain.model.Lotto;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        if (number < 0) {
            throw new IllegalStateException("음수는 로또 번호가 아닙니다.");
        }
        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return this.number == bonusNumber.getNumber();
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.getNumber() - other.getNumber();
    }
}
