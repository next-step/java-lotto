package refactoringlotto;

import java.util.List;

public class LottoWinningNumbers {
    private final LottoNumbers lottoWinningNumbers;

    public LottoWinningNumbers(List<Integer> lottoWinningList) {
        lottoWinningNumbers = new LottoNumbers(lottoWinningList);
    }

    public int lottoRank(List<LottoNumber> lottoNumbers) {
        return lottoWinningNumbers.lottoRank(lottoNumbers);
    }
}
