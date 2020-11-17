package lotto.domain.lotto;

import lotto.domain.Money;
import lotto.domain.lotto.strategy.LottoNumberCreateStrategy;
import lotto.domain.lotto.strategy.LottoNumbersCreateStrategy;
import lotto.domain.lotto.strategy.RandomNumberCreateStrategy;
import lotto.domain.lotto.strategy.RandomNumbersCreateStrategy;

import java.util.*;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class LottoTicket {
    private static final Money PRICE = Money.of(1000);
    private static final LottoNumbersCreateStrategy DEFAULT_CREATE_NUMBER_STRATEGY = new RandomNumbersCreateStrategy();
    private static final LottoNumberCreateStrategy DEFAULT_CREATE_BONUS_NUMBER_STRATEGY = new RandomNumberCreateStrategy();
    public static final String LOTTO_NUMBER_MUST_NOT_BE_NULL = "lotto number must not be null";
    public static final String LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED = "lotto number must not be duplicated";

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    private LottoTicket(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoTicket of(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        checkArgument(lottoNumbers != null, LOTTO_NUMBER_MUST_NOT_BE_NULL);
        checkArgument(hasNotDuplicates(lottoNumbers, bonusNumber), LOTTO_NUMBER_MUST_NOT_BE_DUPLICATED);
        return new LottoTicket(lottoNumbers, bonusNumber);
    }

    public static LottoTicket of(final LottoNumbersCreateStrategy lottoNumbersStrategy, final LottoNumberCreateStrategy bonusNumberStrategy) {
        final LottoNumber bonusNumber = bonusNumberStrategy.create();
        return of(lottoNumbersStrategy.create(bonusNumber), bonusNumber);
    }

    public static LottoTicket of() {
        return of(DEFAULT_CREATE_NUMBER_STRATEGY, DEFAULT_CREATE_BONUS_NUMBER_STRATEGY);
    }

    public static LottoTicket of(final String lottoNumberExpression, final int bonusNumber) {
        return of(LottoNumbers.of(lottoNumberExpression), LottoNumber.of(bonusNumber));
    }

    public static boolean hasNotDuplicates(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        return !hasDuplicates(lottoNumbers, bonusNumber);
    }

    public static boolean hasDuplicates(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        final Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers.get());
        lottoNumberSet.add(bonusNumber);
        return lottoNumberSet.size() < lottoNumbers.size() + 1;
    }

    public int countHitNumber(final LottoTicket winLottoTicket) {
        return lottoNumbers.countHitNumber(winLottoTicket.lottoNumbers);
    }

    public boolean isMatchBonus(final LottoTicket lottoTicket) {
        return this.bonusNumber.equals(lottoTicket.bonusNumber);
    }

    public static Money getPrice() {
        return PRICE;
    }

    public List<Integer> getLottoNumber() {
        final List<LottoNumber> lottoNumbersContainBonusNo = new ArrayList<>(lottoNumbers.get());
        lottoNumbersContainBonusNo.add(bonusNumber);
        return lottoNumbersContainBonusNo.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
