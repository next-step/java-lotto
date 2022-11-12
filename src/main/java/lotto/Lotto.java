package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<LottoNumbers> lottoNumbers;

    public Lotto(List<LottoNumbers> manualNumbers, List<LottoNumbers> autoNumbers) {
        this(Stream.concat(manualNumbers.stream(), autoNumbers.stream())
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<LottoResult> match(WinningLotto winingLotto) {
        List<LottoResult> result = new ArrayList<>();
        for (LottoNumbers numbers : lottoNumbers) {
            result.add(winingLotto.match(numbers));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
