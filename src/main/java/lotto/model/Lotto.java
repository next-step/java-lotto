package lotto.model;

import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import lotto.util.NumbersCreator;

import java.util.*;

public class Lotto {

//    public static final String LOTTO_NUMBER_ALLOWED_BETWEEN_1_TO_45_INTEGER = "로또번호는 1~45 사이의 정수값만 허용됩니다.";
    public static final String LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED = "로또번호목록은 중복될수 없습니다.";
    public static final String LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6 = "로또번호목록은 반드시 6개의 로또번호를 입력해야 합니다..(6,7,17,28,39,45)";
    public static final int LOTTO_NUMBERS_SIZE = 6;
//    public static final int MIN_LOTTO_NUMBER = 1;
//    public static final int MAX_LOTTO_NUMBER = 45;
//    private final List<Integer> lottoNumbers;
    private final List<LottoNumber> lottoNumbers;

    private Lotto(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(final NumbersCreator numbersCreator) {
        List<LottoNumber> result = new ArrayList<>(numbersCreator.create());
        validateLottoNumbers(result);
        result.sort(LottoNumber::compareTo);
        return new Lotto(Collections.unmodifiableList(result));
    }

    private static void validateLottoNumbers(List<LottoNumber> result) {
        int lottoNumbersSize = result.size();

        int distinctLottoNumbersSize = new HashSet<>(result).size();
        boolean isLottoNumberDuplicated = distinctLottoNumbersSize < lottoNumbersSize;
        if (isLottoNumberDuplicated) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED);
        }

        boolean isLottoNumbersSizeEqualSix = lottoNumbersSize != LOTTO_NUMBERS_SIZE;
        if (isLottoNumbersSizeEqualSix) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6);
        }
    }

//    private static void validateLottoNumber(int lottoNumber) {
//        boolean isLottoNumberValidRange = lottoNumber < MIN_LOTTO_NUMBER ||
//                lottoNumber > MAX_LOTTO_NUMBER;
//        if (isLottoNumberValidRange) {
//            throw new IllegalArgumentException(LOTTO_NUMBER_ALLOWED_BETWEEN_1_TO_45_INTEGER);
//        }
//    }

    public List<LottoNumber> numbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public Ranking compare(Lotto winning) {
        return Ranking.result(matchedCount(winning));
    }

    private int matchedCount(Lotto winning) {
        return (int) lottoNumbers.stream()
                .filter(winning.lottoNumbers::contains)
                .count();
    }
}
