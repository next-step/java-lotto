package lotto.domain;

import java.util.List;

public class WinningLotto extends AbstractLotto {
    public WinningLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static WinningLotto from(String[] winningNumbers) {
        List<LottoNumber> lottoNumbers = ManualLottoNumbersGenerator.from(winningNumbers).generate();

        return new WinningLotto(lottoNumbers);
    }

    public int matchCount(Lotto other) {
        int matchCount = 0;

        for (LottoNumber number : other.lottoNumbers) {
            for (LottoNumber winningLottoNumber : this.lottoNumbers) {
                if (number.compareTo(winningLottoNumber) == 0) {
                    matchCount ++;
                }
            }
        }

        return matchCount;
    }
}
