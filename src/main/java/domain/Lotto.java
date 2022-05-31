package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static Cash PRICE = new Cash(1000);
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatch(LottoNumbers comparedNumbers) {
        Set<LottoNumber> mergedLottoNumbers = mergeIntoSet(comparedNumbers, this.lottoNumbers);
        return 2 * LottoNumbers.LOTTO_NUMBER_COUNT - mergedLottoNumbers.size();
    }

    private Set<LottoNumber> mergeIntoSet(LottoNumbers lottoNumbers1, LottoNumbers lottoNumbers2) {
        Set<LottoNumber> mergedLottoNumbers = new HashSet<>();
        mergedLottoNumbers.addAll(lottoNumbers1.toList());
        mergedLottoNumbers.addAll(lottoNumbers2.toList());
        return mergedLottoNumbers;
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

    @Override
    public String toString() {
        List<String> lottoNumbersString = lottoNumbers.toList().stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());
        return "[" + String.join(", ", lottoNumbersString) + "]";
    }
}
