package lotto.domain.lotto;

import lotto.domain.rank.BonusMatch;
import lotto.domain.rank.LottoMatchCount;
import lotto.domain.rank.Rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER_LENGTH = 6;

    private final List<LottoNumber> numbers;

    public Lotto(String[] stringNumbers) {
        this(Arrays.stream(stringNumbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> numbers) {
        assertNumbersLength(numbers);
        assertNumbersNotDuplicated(numbers);
        this.numbers = numbers;
    }

    private void assertNumbersLength(List<LottoNumber> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또는 6개의 숫자가 필요합니다.");
        }
    }

    private void assertNumbersNotDuplicated(List<LottoNumber> numbers) {
        int distinctCount = (int) numbers.stream().distinct().count();
        if (distinctCount != NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복되지 않는 번호를 입력해주세요.");
        }
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public Rank rank(WinningLotto winningLotto) {
        final LottoMatchCount matchCount = matchCount(winningLotto.numbers());
        final BonusMatch bonusMatch = new BonusMatch(contains(winningLotto.bonusNumber()));
        return Rank.valueOf(matchCount, bonusMatch);
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public LottoMatchCount matchCount(Lotto winningNumbers) {
        return new LottoMatchCount(
                (int) numbers.stream()
                        .filter(winningNumbers::contains)
                        .count());
    }
}
