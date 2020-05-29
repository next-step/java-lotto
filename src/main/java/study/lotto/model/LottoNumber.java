package study.lotto.model;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private int number;

    public LottoNumber(int number) {
        if(isValid(number)) {
            this.number = number;
        }
    }

    private boolean isValid(int number) {
        if(number < LOTTO_NUMBER_MIN) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_MIN + "보다 작을 수 없습니다.");
        }

        if(number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_MAX + "보다 클 수 없습니다.");
        }

        return true;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(lottoNumber.getNumber(), number);
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof LottoNumber) {
            return number == ((LottoNumber) object).getNumber();
        }

        return false;
    }
}
