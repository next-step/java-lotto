package model.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String INVALID_LOTTO_SIZE = "하나의 로또엔 6개의 숫자여야 한다.";
    private static final String NUMBER_DELIMITER = ", ";
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        checkValidLotto(numbers);
        this.lottoNumbers = toLottoNumber(numbers);
    }

    public Lotto(String[] value) {
        this(Arrays.stream(value)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public Lotto(String value) {
        this(value.split(NUMBER_DELIMITER));
    }

    private Set<LottoNumber> toLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private void checkValidLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    public Rank countWinningNumbers(WinningLotto winningLotto) {
        int lottoCount = (int) lottoNumbers.stream()
                .filter(winningLotto::containsWinNumber)
                .count();
        int bonusCount = (int) lottoNumbers.stream()
                .filter(winningLotto::containsWinBonusNumber)
                .count();
        return Rank.of(lottoCount, bonusCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .map(LottoNumber::toString)
                .collect(Collectors.joining(NUMBER_DELIMITER))
                + "]";
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
