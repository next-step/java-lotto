package study.step3.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final String LOTTO_NULL_EXCEPTION = "당첨번호는 빈 값을 입력할 수 없습니다.";
    private static final String LOTTO_LIMIT_NUMBER_EXCEPTION = "로또 번호는 1보다 작거나 45보다 클 수 없습니다.";
    private static final String LOTTO_BONUS_BALL_EXCEPTION = "이미 입력한 번호는 보너스로 입력 불가합니다.";
    private static final LottoNumber [] CACHE = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                                                        .mapToObj(LottoNumber::new)
                                                        .toArray(LottoNumber[]::new);

    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        this(convertToInt(validateLottoNumberString(lottoNumber)));
    }

    private static int convertToInt(String lottoNumber) {
        return Integer.parseInt(lottoNumber);
    }

    private static String validateLottoNumberString(String inputLottoNumbers) {
        if (Objects.isNull(inputLottoNumbers) || inputLottoNumbers.trim().isEmpty()){
            throw new IllegalArgumentException(LOTTO_NULL_EXCEPTION);
        }
        return inputLottoNumbers;
    }

    private LottoNumber(int lottoNumber) {
        lottoLimitValid(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void lottoLimitValid(int lottoNumber) {
        if (!isRangeClosed(lottoNumber)){
            throw new IllegalArgumentException(LOTTO_LIMIT_NUMBER_EXCEPTION);
        }
    }

    private static boolean isRangeClosed(int lottoNumber) {
        return lottoNumber <= LOTTO_MAX_NUMBER && lottoNumber >= LOTTO_MIN_NUMBER;
    }

    public static LottoNumber cacheNumber(int number){
        lottoLimitValid(number);
        return CACHE[--number];
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public void validateDuplicationBonusBall(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.contains(this)){
            throw new IllegalArgumentException(LOTTO_BONUS_BALL_EXCEPTION);
        }
    }

    public boolean isMatch(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(this);
    }

    @Override
    public int compareTo(LottoNumber compareLottoNumber) {
        return this.lottoNumber - compareLottoNumber.lottoNumber;
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
