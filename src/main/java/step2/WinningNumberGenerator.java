package step2;

import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.WinningNumbers;
import step2.strategy.NumberMakeStrategy;

import java.util.Set;

public class WinningNumberGenerator {
    public static WinningNumbers create(NumberMakeStrategy numberMakeStrategy){
        Set<LottoNumber> lottoNumbers = numberMakeStrategy.create();
        return WinningNumbers.of(lottoNumbers);
    }
}
