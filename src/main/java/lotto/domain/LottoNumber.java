package lotto.domain;

import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final Random RANDOM = new Random();
    public static final int LOTTO_LOWER_BOUND = 1;
    public static final int LOTTO_UPPER_BOUND = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        checkLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void checkLottoNumberRange(int lottoNumber) {
        if (lottoNumber < LOTTO_LOWER_BOUND || lottoNumber > LOTTO_UPPER_BOUND) {
            throw new IllegalArgumentException(lottoNumber + "번은 로또 숫자 범위가 아닙니다. (1 - 45 사이만 입력해주세요.)");
        }
    }

    public static LottoNumber createLottoNumber() {
        return new LottoNumber(RANDOM.nextInt(LOTTO_UPPER_BOUND) + LOTTO_LOWER_BOUND);
    }

    public static LottoNumber createManualLottoNumber(String stringLottoNumber) {
        String lottoNumber = stringLottoNumber.strip();
        try {
            return new LottoNumber(Integer.parseInt(lottoNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(lottoNumber + "는 숫자가 아닙니다. 숫자만 입력해주세요!");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber LottoNumber) {
        return Integer.compare(lottoNumber, LottoNumber.getLottoNumber());
    }

    @Override
    public String toString() {
        return "" + lottoNumber;
    }
}
