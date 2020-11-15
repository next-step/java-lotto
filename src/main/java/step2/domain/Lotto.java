package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class Lotto {
    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final Money PRICE = Money.of(1000);
    private static final CreateLottoNumbersStrategy DEFAULT_CREATE_NUMBER_STRATEGY = new CreateRandomNumbersStrategy();
    public static final String LOTTO_NUMBER_MUST_NOT_BE_NULL = "lotto number must not be null";
    public static final String LOTTO_NUMBER_SIZE_NOT_VALID = "lotto number size must be " + LOTTO_NUMBERS_LENGTH;

    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(final List<LottoNumber> numbers) {
        checkArgument(numbers != null, LOTTO_NUMBER_MUST_NOT_BE_NULL);
        checkArgument(numbers.size() == LOTTO_NUMBERS_LENGTH, LOTTO_NUMBER_SIZE_NOT_VALID);
        return new Lotto(numbers);
    }
    
    public static Lotto of(final CreateLottoNumbersStrategy strategy) {
        return of(strategy.create());
    }

    public static Lotto of() {
        return of(DEFAULT_CREATE_NUMBER_STRATEGY);
    }

    public int countHitNumber(final Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto.numbers::contains).count();
    }

    public static Money getPrice() {
        return PRICE;
    }

    public static int getLottoNumbersLength() {
        return LOTTO_NUMBERS_LENGTH;
    }

    public List<Integer> getLottoNumber() {
        return numbers.stream().map(LottoNumber::getValue).collect(Collectors.toList());
    }
}
