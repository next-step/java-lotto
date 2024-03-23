package lotto.domain;

import java.util.List;
import java.util.Optional;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    public static final int PRICE = 1000;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }

    public Optional<LottoWinningRank> isWinningLotto(WinningLotto winningLottoLotto) {
        LottoNumbers winningLottoNumbers = winningLottoLotto.getLottoNumbers();
        LottoNumber winningBonusNumber = winningLottoLotto.getBonusNumber();

        int matchCount = this.lottoNumbers.matchCount(winningLottoNumbers);
        boolean matchBonus = this.lottoNumbers.isContainNumber(winningBonusNumber);

        return LottoWinningRank.findByMatchCount(matchCount, matchBonus);
    }
}
