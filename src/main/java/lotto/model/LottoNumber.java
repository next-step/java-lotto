package lotto.model;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumber {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    public static final String INVALID_LOTTO_NUMBER = "로또 번호는 1이상, 45 이하의 숫자만 사용 가능합니다.";

    public static List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed()
                .collect(toList());
    }

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validateNumber(int lotto) {
        if (!isValidLottoNumber(lotto)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

    public static LottoNumber getRandomLottoNumber(Random random) {
        return new LottoNumber(lottoNumbers.get(random.nextInt(LOTTO_END_NUMBER)));
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    public boolean isSameNumber(int number) {
        return lottoNumber == number;
    }
}
