package lotto.model;

import lotto.utils.LottoNumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    public static final int MAX_LENGTH_LOTTO = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this(LottoNumberGenerator.generateLottoNumbers());
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkDuplicatedNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    void checkDuplicatedNumber(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != lottoNumberSet.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    long countSameLottoNumber(LottoNumbers lottoNumbers) {
        List<LottoNumber> numbers = lottoNumbers.getLottoNumbers();
        return this.lottoNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public Rank getRank(LottoNumbers winningNumbers) {
        return Rank.of(countSameLottoNumber(winningNumbers));
    }
}
