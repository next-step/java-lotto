package lotto.domain.lotto;

import util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class LottoNumbers {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final String SEPARATOR = ", ";
    public static final String LOTTO_NUMBER_MUST_NOT_BE_NULL = "lotto number must not be null";
    public static final String LOTTO_NUMBER_SIZE_NOT_VALID = "lotto number size must be " + LOTTO_NUMBERS_LENGTH;
    public static final String LOTTO_NUMBER_MUST_NOT_BE_BLANK = "lotto number must not be blank";
    public static final String LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED = "lotto number must not be duplicated";
    
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static LottoNumbers of(final List<LottoNumber> lottoNumbers) {
        checkArgument(lottoNumbers != null, LOTTO_NUMBER_MUST_NOT_BE_NULL);
        checkArgument(lottoNumbers.size() == LOTTO_NUMBERS_LENGTH, LOTTO_NUMBER_SIZE_NOT_VALID);
        checkArgument(hasNotDuplicates(lottoNumbers), LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
        lottoNumbers.sort(Comparator.comparing(LottoNumber::getValue));
        return new LottoNumbers(lottoNumbers);
    }
    
    public static LottoNumbers of(final String lottoNumberExpression) {
        checkArgument(StringUtils.isNotBlank(lottoNumberExpression), LOTTO_NUMBER_MUST_NOT_BE_BLANK);
        final List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumberExpression.split(SEPARATOR))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return of(lottoNumbers);
    }

    public static boolean hasNotDuplicates(final List<LottoNumber> lottoNumbers) {
        return !hasDuplicates(lottoNumbers);
    }

    public static boolean hasDuplicates(final List<LottoNumber> lottoNumbers) {
        final Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        return lottoNumberSet.size() < lottoNumbers.size();
    }
    
    public int countHitNumber(final LottoNumbers winLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winLottoNumbers.get()::contains).count();
    }

    public List<LottoNumber> get() {
        return lottoNumbers;
    }
    
    public int size() {
        return lottoNumbers.size();
    }
}