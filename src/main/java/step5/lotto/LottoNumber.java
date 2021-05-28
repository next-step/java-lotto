package step5.lotto;

public class LottoNumber implements Comparable<LottoNumber> {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private final static String OUT_OF_RANGE = "로또번호는 1~45의 범위입니다.";

    private int lottoNumber;

    public LottoNumber(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new RuntimeException(OUT_OF_RANGE);
        }
        this.lottoNumber = number;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber number) {
        if (this.lottoNumber < number.lottoNumber) {
            return -1;
        } else if(this.lottoNumber == number.lottoNumber) {
            return 0;
        } else {
            return 1;
        }
    }
}
