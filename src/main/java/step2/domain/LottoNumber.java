package step2.domain;

public class LottoNumber {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validation(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validation(int lottoNumber) {
        if(lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1~45의 숫자를 생성해주세요.");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
