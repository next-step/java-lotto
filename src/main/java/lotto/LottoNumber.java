package lotto;

class LottoNumber {
    private final Integer number;

    public LottoNumber(final int number) {
        checkNumber(number);
        this.number = number;
    }

    private void checkNumber(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("유효한 숫자 범위는 1~45 입니다.");
        }
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return number.equals(((LottoNumber) obj).number);
    }

    public int compareTo(LottoNumber target) {
        return number.compareTo(target.number);
    }
}
