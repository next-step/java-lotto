package lotto.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SUB_LIST_INIT_INDEX = 0;
    private static final int SUB_LIST_LAST_INDEX = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> numbers) {
        validateSize(numbers);
        lottoNumbers = numbers;
    }

    public static Lotto valueOf(List<LottoNumber> numbers) {
        return new Lotto(numbers.subList(SUB_LIST_INIT_INDEX, SUB_LIST_LAST_INDEX).stream().collect(Collectors.toSet()));
    }

    public static Lotto valueOf(Set<LottoNumber> numbers) {
        return new Lotto(numbers);
    }


    public boolean isCollectBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int matchCount(Lotto winningNumbers) {
        Set<LottoNumber> copy = new HashSet<>(lottoNumbers);
        copy.retainAll(winningNumbers.lottoNumbers);
        return copy.size();
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers.stream().map(lottoNumber -> lottoNumber.getInteger()).collect(Collectors.toSet());
    }

    private void validateSize(Set<LottoNumber> result) {
        if (result.size() != SUB_LIST_LAST_INDEX) {
            throw new IllegalArgumentException("사이즈가 여섯 개 아님");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
