package step5.domain;

public class LottoNumber {
    private static final Integer MIN = 1;
    private static final Integer MAX = 45;
    private final Integer lottoNumber;

    public LottoNumber(String lottoNumber) {
        this(Integer.parseInt(lottoNumber));
    }

    public LottoNumber(Integer lottoNumber) {
        checkValidRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void checkValidRange(Integer lottoNumber) {
        if (lottoNumber < MIN || lottoNumber > MAX) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이 값이어야 합니다.");
        }
    }

    public Integer number() {
        return lottoNumber;
    }
}
