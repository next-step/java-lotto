import java.util.Random;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int lottoNumber) {
        if ( 45 < lottoNumber ) {
            throw new IllegalArgumentException("로또 번호에 맞는 숫자여야합니다.");
        }

        if (lottoNumber < 1) {
            throw new IllegalArgumentException("로또 번호에 맞는 숫자여야합니다.");
        }

        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber defaultOf() {
        Random random = new Random();
        int lottoNumber = random.nextInt(46);
        return new LottoNumber(lottoNumber);
    }
}
