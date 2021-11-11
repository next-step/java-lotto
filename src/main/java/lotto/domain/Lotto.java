package lotto.domain;

import lotto.vo.LottoNumber;
import lotto.vo.LottoRule;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final String RANGE_EXCEPTION_MESSAGE = "로또의 숫자 개수가 맞지 않습니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<LottoNumber> lottoNumberList) {

        if (lottoNumberList == null || lottoNumberList.size() != LottoRule.LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
        Collections.sort(lottoNumberList);
        return new Lotto(lottoNumberList);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public WinningRank checkWinning(Lotto winningLotto) {
        return WinningRank.getWinningRankWithMatchCount(getCountOfMatch(winningLotto));
    }

    private long getCountOfMatch(Lotto winningLotto) {
        return lottoNumbers.stream()
                .filter(winningLotto.lottoNumbers::contains)
                .count();
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
