package lotto.domain;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다");
        }
    }

    public int findLottoNumber() {
        return number;
    }
}
