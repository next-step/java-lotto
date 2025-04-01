package step2.domain.lotto;

import views.LottoFormatter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers, LottoRule lottoRule) {
        if (!lottoRule.isSatisfied(lottoNumbers)) {
            throw new IllegalArgumentException("규칙을 만족하지 않는 숫자 입력입니다");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(LottoRule lottoRule) {
        this.lottoNumbers = lottoRule.generateLotto();
    }

    public LottoFormatter generateFormatter() {
        return new LottoFormatter(this.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public Set<Integer> matchedWith(Lotto lotto) {
        return findMatchingNumbers(lotto.getLottoNumbers());
    }

    public Set<Integer> notMatchedWith(Lotto lotto) {
        return findNotMatchingNumbers(lotto.getLottoNumbers());
    }

    private Set<Integer> findMatchingNumbers(List<Integer> inputNumbers) {
        Set<Integer> inputSet = new HashSet<>(inputNumbers);
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        inputSet.retainAll(lottoSet);
        return inputSet;
    }

    private Set<Integer> findNotMatchingNumbers(List<Integer> inputNumbers) {
        Set<Integer> inputSet = new HashSet<>(inputNumbers);
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        inputSet.removeAll(lottoSet);
        return inputSet;
    }
}
