package step2.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (!checkValid(lottoNumbers)) {
            throw new IllegalArgumentException("규칙을 만족하지 않는 숫자 입력입니다.");
        }

        Set<LottoNumber> lottoNumberSet = toLottoNumberSet(lottoNumbers);
        this.lottoNumbers = new LottoNumbers(lottoNumberSet);
    }

    private Lotto(LottoNumbers lottoNumbers) {
        if (!checkValid(lottoNumbers)) {
            throw new IllegalArgumentException("규칙을 만족하지 않는 숫자 입력입니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto auto(LottoGenerator lottoGenerator) {
        return new Lotto(lottoGenerator.generateLotto());
    }

    private Set<LottoNumber> toLottoNumberSet(List<Integer> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        for (int number : lottoNumbers) {
            lottoNumberSet.add(new LottoNumber(number));
        }
        return lottoNumberSet;
    }

    private boolean checkValid(List<Integer> lottoNumbers) {
        return hasAllDistinctValues(lottoNumbers) && hasCorrectSize(lottoNumbers);
    }

    private boolean checkValid(LottoNumbers lottoNumbers) {
        return lottoNumbers.size() == LottoConstants.NUMBERS_PER_LOTTO;
    }

    private boolean hasAllDistinctValues(List<Integer> lottoNumbers) {
        Set<Integer> distinct = new HashSet<>(lottoNumbers);
        return distinct.size() == lottoNumbers.size();
    }

    private boolean hasCorrectSize(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == LottoConstants.NUMBERS_PER_LOTTO;
    }

    public Set<LottoNumber> copyLottoNumbers() {
        return new HashSet<>(this.lottoNumbers.getLottoNumberSet());
    }

    public boolean contains(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        return lottoNumbers.contains(lottoNumber);
    }

    public LottoNumbers matchedWith(Lotto lotto) {
        return findMatchingNumbers(lotto.copyLottoNumbers());
    }

    public LottoNumbers notMatchedWith(Lotto lotto) {
        return findNotMatchingNumbers(lotto.copyLottoNumbers());
    }

    private LottoNumbers findMatchingNumbers(Set<LottoNumber> inputNumbers) {
        return lottoNumbers.findIntersection(inputNumbers);
    }

    private LottoNumbers findNotMatchingNumbers(Set<LottoNumber> inputNumbers) {
        return lottoNumbers.findDifference(inputNumbers);
    }
}
