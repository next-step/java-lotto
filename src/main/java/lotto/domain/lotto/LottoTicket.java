package lotto.domain.lotto;

import lotto.domain.Money;
import lotto.domain.lotto.strategy.LottoNumberCreateStrategy;
import lotto.domain.lotto.strategy.LottoNumbersCreateStrategy;
import lotto.domain.lotto.strategy.RandomNumberCreateStrategy;
import lotto.domain.lotto.strategy.RandomNumbersCreateStrategy;
import util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final Money PRICE = Money.of(1000);
    private static final LottoNumbersCreateStrategy DEFAULT_CREATE_NUMBER_STRATEGY = new RandomNumbersCreateStrategy();
    private static final LottoNumberCreateStrategy DEFAULT_CREATE_BONUS_NUMBER_STRATEGY = new RandomNumberCreateStrategy();
    public static final String LOTTO_NUMBER_MUST_NOT_BE_NULL = "lotto number must not be null";
    public static final String LOTTO_NUMBER_SIZE_NOT_VALID = "lotto number size must be " + LOTTO_NUMBERS_LENGTH;
    public static final String LOTTO_NUMBER_MUST_NOT_BE_BLANK = "lotto number must not be blank";
    public static final String LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED = "lotto number must not be duplicated";
    private static final String SEPARATOR = ", ";

    private final List<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    private LottoTicket(final List<LottoNumber> numbers, final LottoNumber bonusNumber) {
        this.numbers = Collections.unmodifiableList(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static LottoTicket of(final List<LottoNumber> numbers, final LottoNumber bonusNumber) {
        checkArgument(numbers != null, LOTTO_NUMBER_MUST_NOT_BE_NULL);
        checkArgument(numbers.size() == LOTTO_NUMBERS_LENGTH, LOTTO_NUMBER_SIZE_NOT_VALID);
        checkArgument(hasNotDuplicates(numbers, bonusNumber), LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
        numbers.sort(Comparator.comparing(LottoNumber::getValue));
        return new LottoTicket(numbers, bonusNumber);
    }

    public static LottoTicket of(final LottoNumbersCreateStrategy lottoNumbersStrategy, final LottoNumberCreateStrategy bonusNumberStrategy) {
        final LottoNumber bonusNumber = bonusNumberStrategy.create();
        return of(lottoNumbersStrategy.create(bonusNumber), bonusNumber);
    }

    public static LottoTicket of() {
        return of(DEFAULT_CREATE_NUMBER_STRATEGY, DEFAULT_CREATE_BONUS_NUMBER_STRATEGY);
    }

    public static LottoTicket of(final String lottoNumberExpression, final int bonusNumber) {
        checkArgument(StringUtils.isNotBlank(lottoNumberExpression), LOTTO_NUMBER_MUST_NOT_BE_BLANK);
        final List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumberExpression.split(SEPARATOR))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return of(lottoNumbers, LottoNumber.of(bonusNumber));
    }

    public static boolean hasNotDuplicates(final List<LottoNumber> numbers, final LottoNumber bonusNumber) {
        return !hasDuplicates(numbers, bonusNumber);
    }

    public static boolean hasDuplicates(final List<LottoNumber> numbers, final LottoNumber bonusNumber) {
        final Set<LottoNumber> lottoNumberSet = new HashSet<>(numbers);
        lottoNumberSet.add(bonusNumber);
        return lottoNumberSet.size() < numbers.size() + 1;
    }

    public int countHitNumber(final LottoTicket lottoTicket) {
        return (int) this.numbers.stream()
                .filter(lottoTicket.numbers::contains).count();
    }

    public boolean isMatchBonus(final LottoTicket lottoTicket) {
        return this.bonusNumber.equals(lottoTicket.bonusNumber);
    }

    public static Money getPrice() {
        return PRICE;
    }

    public static int getLottoNumbersLength() {
        return LOTTO_NUMBERS_LENGTH;
    }

    public List<Integer> getLottoNumber() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
