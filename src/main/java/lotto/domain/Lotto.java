package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkValidation(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static void checkValidation(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("Wrong number count");
        }
    }

    public static Lotto from(List<String> lottoNumbers) {
        return new Lotto(lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public LottoRank matchWinLotto(Lotto winLotto) {
        return LottoRank.valueOfMatchCount(
            (int) this.lottoNumbers.stream()
                .filter((winLotto.lottoNumbers::contains))
                .count()
        );
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
