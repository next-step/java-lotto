package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int MAX_GENERATE_COUNT = 6;
    private static final int MAX_GENERATE_WITH_BONUS_COUNT = 7;
    private static final int MAX_NUMBER = 45;

    private final Set<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    public Lotto() {
        this.numbers = new TreeSet<>(getShuffleNumbers());
        this.bonusNumber = null;
    }

    public Lotto(final Set<LottoNumber> numbers) {
        validateNumberSize(numbers);
        this.numbers = new TreeSet<>(numbers);
        this.bonusNumber = null;
    }

    public Lotto(final Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
        validateNumberCountWithBonus(numbers);
        this.numbers = new TreeSet<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    private void validateNumberCountWithBonus(final Set<LottoNumber> numbers) {
        if (numbers.size() + 1 != MAX_GENERATE_WITH_BONUS_COUNT) {
            throw new IllegalArgumentException("보너스번호를 포함한 로또번호가 개수가 일치하지 않습니다.");
        }
    }

    private void validateNumberSize(final Set<LottoNumber> numbers) {
        if (numbers.size() != MAX_GENERATE_COUNT) {
            throw new IllegalArgumentException("로또번호의 개수가 일치하지 않습니다.");
        }
    }

    private Set<LottoNumber> getShuffleNumbers() {
        List<LottoNumber> allNumbers = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            allNumbers.add(LottoNumber.valueOf(i));
        }
        Collections.shuffle(allNumbers);

        return new HashSet<>((allNumbers.subList(0, MAX_GENERATE_COUNT)));
    }

    public LottoMatchNumberInfo getLottoMatchNumberInfo(final Lotto winninglotto) {
        if (winninglotto == null) {
            return new LottoMatchNumberInfo(0, false);
        }
        int matchingCount = (int) numbers.stream()
                .filter(winninglotto.numbers::contains)
                .count();
        boolean isBonusMatch = Optional.ofNullable(winninglotto.bonusNumber)
                .map(numbers::contains)
                .orElse(false);
        return new LottoMatchNumberInfo(matchingCount, isBonusMatch);
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
