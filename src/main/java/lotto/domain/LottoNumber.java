package lotto.domain;

public class LottoNumber {
    private int number;
    public LottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자입니다.");
        }
        this.number = number;
    }
}
