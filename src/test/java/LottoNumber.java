public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber defaultOf(int lottoNumber) {
        if ( 45 < lottoNumber ) {
            throw new IllegalArgumentException("로또 번호에 맞는 숫자여야합니다.");
        }

        if (lottoNumber < 1) {
            throw new IllegalArgumentException("로또 번호에 맞는 숫자여야합니다.");
        }

        return new LottoNumber(lottoNumber);
    }
}
