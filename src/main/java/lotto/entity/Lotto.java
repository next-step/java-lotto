package lotto.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SUB_LIST_INIT_INDEX = 0;
    private static final int SUB_LIST_LAST_INDEX = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this(new HashSet<>(numbers.subList(SUB_LIST_INIT_INDEX, SUB_LIST_LAST_INDEX)));
    }

    public Lotto(Set<Integer> numbers) {
        validateSize(numbers);
        lottoNumbers = numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toSet());
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

    private void validateSize(Set<Integer> result) {
        if (result.size() != SUB_LIST_LAST_INDEX) {
            throw new IllegalArgumentException("사이즈가 여섯 개 아님");
        }
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
