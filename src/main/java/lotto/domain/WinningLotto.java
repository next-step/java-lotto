package lotto.domain;

import lotto.domain.numbergenerator.ManualLottoNumbersGenerator;

import java.util.List;

public class WinningLotto extends AbstractLotto {
    private WinningLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static WinningLotto from(String[] winningNumbers) {
        List<LottoNumber> lottoNumbers = ManualLottoNumbersGenerator.from(winningNumbers).generate();

        return new WinningLotto(lottoNumbers);
    }

    public int matchCount(Lotto other) {
        return other.lottoNumbers.stream()
                .mapToInt(number -> (int) this.lottoNumbers.stream()
                .filter(number::equals)
                .count())
                .sum();
    }
}
