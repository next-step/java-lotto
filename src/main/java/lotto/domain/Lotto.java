package lotto.domain;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final LottoNumbers lottoNumbers;

    public Lotto(final LottoNumbers lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 정확히" + LOTTO_NUMBER_COUNT + "개 여야 합니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public boolean isMatch(final Lotto otherLotto) {
        return lottoNumbers.isMatch(otherLotto.lottoNumbers);
    }

    public int matchCount(final Lotto otherLotto) {
        return (int) lottoNumbers.matchCount(otherLotto.lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
