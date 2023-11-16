package lottosecond.domain.lotto;

import java.util.Set;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 반드시 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int getLottoScore(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto.lottoNumbers::contains)
                .count();
    }

    public boolean hasLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
