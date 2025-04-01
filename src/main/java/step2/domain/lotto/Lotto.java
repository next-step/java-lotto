package step2.domain.lotto;

import views.LottoFormatter;

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

    public Set<Integer> findMatchingNumbers(List<Integer> winningNumbers) {
        Set<Integer> winningSet = new HashSet<>(winningNumbers);
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        winningSet.retainAll(lottoSet);
        return winningSet;
    }

    public Set<Integer> findNotMatchingNumbers(List<Integer> winningNumbers) {
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        Set<Integer> winningSet = new HashSet<>(winningNumbers);
        lottoSet.removeAll(winningSet);
        return lottoSet;
    }
}
