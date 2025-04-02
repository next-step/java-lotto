package step2.domain.lotto;

import java.util.Set;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> getLottoNumberSet() {
        return lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public LottoNumbers findIntersection(Set<LottoNumber> intersection) {
        intersection.retainAll(this.lottoNumbers);
        return new LottoNumbers(intersection);
    }

    public LottoNumbers findDifference(Set<LottoNumber> difference) {
        difference.removeAll(this.lottoNumbers);
        return new LottoNumbers(difference);
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }
}
