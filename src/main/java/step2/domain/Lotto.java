package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final Integer LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public Lotto(Lotto lotto) {
        validateSize(lotto.lottoNumbers);
        this.lottoNumbers = lotto.getLottoNumbers();
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개가 필요합니다. 입력된 로또 번호 갯수 : " + lottoNumbers.size());
        }
    }

    public static Lotto create() {
        return LottoGenerator.generate();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public LottoRank matchLotto(WinningLotto lotto) {
        final long matchCount = lottoNumbers.stream()
                                            .filter(number -> match(number, lotto.getLotto()))
                                            .count();

        return LottoRank.matchOf((int) matchCount);
    }

    private boolean match(final LottoNumber answerNumber, final Lotto lotto) {
        return lotto.lottoNumbers.contains(answerNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
