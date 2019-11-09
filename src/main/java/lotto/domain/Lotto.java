package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getValue();
    }

    public LottoRank matchTo(WinningLotto winningLotto) {
        boolean matchBonusNumber = winningLotto.matchBonusNumber(getLottoNumbers());

        return LottoRank.find(
                getMatchNumberCount(winningLotto.getNumbers()),
                rank -> matchBonusNumber ? LottoRank.SECOND : LottoRank.THIRD);
    }

    private long getMatchNumberCount(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(lottoNumbers.getValue()::contains)
                .count();
    }
}
