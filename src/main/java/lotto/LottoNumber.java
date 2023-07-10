package lotto;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 이내의 숫자로 구성되어야 합니다.");
        }
        this.lottoNumber = lottoNumber;
    }
}
