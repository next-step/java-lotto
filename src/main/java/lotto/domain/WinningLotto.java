package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;

    public WinningLotto(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public LottoRank winningRank(Lotto lotto) {
        int count = lottoNumbers.matchedCount(lotto);

        return LottoRank.searchBy(count);
    }
}
