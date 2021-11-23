package lotto.domain;

import lotto.domain.numbergenerator.ManualLottoNumbersGenerator;
import lotto.exception.BonusNumberException;

import java.util.List;

public class WinningLotto extends AbstractLotto {
    private final LottoNumber bonusNumber;

    private WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new BonusNumberException(bonusNumber);
        }
    }

    public static WinningLotto from(String[] winningNumbers, LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumbers = ManualLottoNumbersGenerator.from(winningNumbers).generate();

        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    public int matchCount(Lotto other) {
        return other.lottoNumbers.stream()
                .mapToInt(number -> (int) this.lottoNumbers.stream()
                        .filter(number::equals)
                        .count())
                .sum();
    }

    public boolean matchBonus(Lotto other) {
        return other.contain(bonusNumber);
    }
}
