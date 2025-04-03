package lotto.domain;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_LENGTH = 6;

    private final Set<LottoNo> lottoNos;

    public Lotto(List<Integer> lottoNumbers) {
        this(new HashSet<>(lottoNumbers.stream().map(LottoNo::new).collect(toSet())));
    }

    public Lotto(Set<LottoNo> lottoNos) {
        checkValid(lottoNos);
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

    private void checkValid(Set<LottoNo> lottoNos) {
        if (lottoNos.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("lotto size is not 6");
        }
    }
}
