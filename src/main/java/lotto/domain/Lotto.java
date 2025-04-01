package lotto.domain;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final Set<LottoNo> lottoNos;

    public Lotto(List<Integer> lottoNumbers) {
        this(new HashSet<>(lottoNumbers.stream().map(LottoNo::new).collect(toSet())));
    }

    public Lotto(Set<LottoNo> lottoNos) {
        this.lottoNos = lottoNos;
    }

    public int matchCount(Lotto lotto) {
        int count = 0;

        for (LottoNo winNumber : lotto.lottoNos) {
            count += isMatch(winNumber) ? 1 : 0;
        }

        return count;
    }

    public boolean isMatch(LottoNo lottoNo) {
        return this.lottoNos.contains(lottoNo);
    }

    public Set<LottoNo> getLottoNumbers() {
        return lottoNos;
    }
}
