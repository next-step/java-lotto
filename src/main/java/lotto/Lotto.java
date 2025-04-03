package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final long LOTTO_NUM_COUNT = 6;

    private final Set<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    public Lotto(Set<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank getLottoRank(List<Integer> winningNumbers, Integer bonusNumber) {
        return LottoRank.fromMatchCount((int) this.lottoNumbers.stream().filter(winningNumbers::contains).count(), lottoNumbers.contains(bonusNumber));
    }

    private void validateLottoNumbers(Set<Integer> numbers) {
        if (numbers.size() > LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (numbers.size() < LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

}
