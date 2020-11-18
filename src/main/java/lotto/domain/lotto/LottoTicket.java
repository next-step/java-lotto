package lotto.domain.lotto;

import lotto.domain.Money;
import lotto.domain.lotto.strategy.LottoNumbersCreateStrategy;
import lotto.domain.lotto.strategy.RandomNumbersCreateStrategy;
import util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final Money PRICE = Money.of(1000);
    private static final String SEPARATOR = ", ";
    private static final LottoNumbersCreateStrategy DEFAULT_CREATE_NUMBER_STRATEGY = new RandomNumbersCreateStrategy();
    public static final String LOTTO_NUMBER_SIZE_NOT_VALID = "lotto number size must be " + LOTTO_NUMBERS_LENGTH;
    public static final String LOTTO_NUMBER_MUST_NOT_BE_NULL = "lotto number must not be null";
    public static final String LOTTO_NUMBER_MUST_NOT_BE_BLANK = "lotto number must not be blank";
    public static final String LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED = "lotto number must not be duplicated";

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getValue))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public static LottoTicket of(final List<LottoNumber> lottoNumbers) {
        checkArgument(lottoNumbers != null, LOTTO_NUMBER_MUST_NOT_BE_NULL);
        checkArgument(lottoNumbers.size() == LOTTO_NUMBERS_LENGTH, LOTTO_NUMBER_SIZE_NOT_VALID);
        checkArgument(hasNotDuplicates(lottoNumbers), LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket of(final LottoNumbersCreateStrategy lottoNumbersStrategy) {
        return of(lottoNumbersStrategy.create());
    }

    public static LottoTicket of() {
        return of(DEFAULT_CREATE_NUMBER_STRATEGY);
    }

    public static LottoTicket of(final String lottoNumberExpression) {
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

    public int countHitNumber(final LottoTicket winLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winLottoNumbers.lottoNumbers::contains).count();
    }

    public boolean isMatchBonus(final LottoNumber bonusNumber) {
        return lottoNumbers
                .stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    public static Money getPrice() {
        return PRICE;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
