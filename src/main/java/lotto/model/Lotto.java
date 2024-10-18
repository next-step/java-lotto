package lotto.model;

import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import lotto.util.NumbersCreator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final String LOTTO_NUMBERS_NOT_ALLOWED_DUPLICATED = "로또번호목록은 중복될수 없습니다.";
    public static final String LOTTO_NUMBERS_SIZE_ALLOWED_ONLY_6 = "로또번호목록은 반드시 6개의 로또번호를 입력해야 합니다..(6,7,17,28,39,45)";
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int BONUS_NUMBER_SIZE = 1;
    private final List<LottoNumber> lottoNumbers;

    private Lotto(final List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        lottoNumbers.sort(LottoNumber::compareTo);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(int... numbers) {
        this(createLottoNumbers(numbers));
    }

    public Lotto(final NumbersCreator numbersCreator) {
        this(createLottoNumbers(numbersCreator));
    }

    private static List<LottoNumber> createLottoNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> createLottoNumbers(NumbersCreator numbersCreator) {
        return new ArrayList<>(numbersCreator.create());
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

    public Ranking compare(Winning winning) {
        Lotto winningLotto = winning.winningLotto();
        LottoNumber bonusNumber = winning.bonusNumber();
        return Ranking.result(matchedCount(winningLotto), isMatchedBonus(bonusNumber));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private boolean isMatchedBonus(LottoNumber bonusNumber) {
        return lottoNumbers.stream().anyMatch(bonusNumber::equals);
    }

    private int matchedCount(Lotto winning) {
        return (int) lottoNumbers.stream()
                .filter(winning.lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
