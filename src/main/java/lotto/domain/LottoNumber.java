package lotto.domain;

public class LottoNumber {

    private int number;

    public LottoNumber(int number) {
        this.number = number;
        lottoNumberAvailable(number);
    }

    public void lottoNumberAvailable(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("유효하지 않은 로또 숫자");
        }
    }
}
