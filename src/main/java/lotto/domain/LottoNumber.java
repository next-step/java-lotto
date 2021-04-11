package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import static lotto.utils.ConvertUtil.toInt;

public class LottoNumber {
    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private static final String CHECK_BOUND = String.format("로또 번호는 %d ~ %d 범위의 값이어야 합니다.", BOUND_MIN, BOUND_MAX);
    private static final String CHECK_LOTTO_NUMBER = "입력하신 로또 번호 %s가 숫자인지 확인해주세요.";
    private static final Random random = new Random();
    private final int lottoNumber;

    static {
        for (int i = BOUND_MIN; i <= BOUND_MAX; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of() {
        return of(random.nextInt(BOUND_MAX) + BOUND_MIN);
    }

    public static LottoNumber of(String lottoNumber) {
        return of(toInt(CHECK_LOTTO_NUMBER, lottoNumber));
    }

    public static LottoNumber of(int lottoNumber) {
        checkBound(lottoNumber);
        return lottoNumbers.get(lottoNumber);
    }

    private static void checkBound(Integer number) {
        if (BOUND_MIN > number || number > BOUND_MAX) {
            throw new IllegalArgumentException(CHECK_BOUND);
        }
    }

    public int lottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
