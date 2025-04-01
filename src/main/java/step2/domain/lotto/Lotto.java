package step2.domain.lotto;

import views.LottoFormatter;

import java.util.Collections;
import java.util.List;

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

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public LottoNumbers matchedWith(Lotto lotto) {
        return findMatchingNumbers(lotto.getLottoNumbers());
    }

    public LottoNumbers notMatchedWith(Lotto lotto) {
        return findNotMatchingNumbers(lotto.getLottoNumbers());
    }

    private LottoNumbers findMatchingNumbers(List<Integer> inputNumbers) {
        return LottoNumbers.findIntersection(inputNumbers, lottoNumbers);
    }

    private LottoNumbers findNotMatchingNumbers(List<Integer> inputNumbers) {
        return LottoNumbers.findDifference(inputNumbers, lottoNumbers);
    }
}
