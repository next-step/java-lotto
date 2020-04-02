package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoNumbersTest {

    @Test
    @DisplayName("당첨번호에 보너스 숫자가 포함되면 IllegalArgumentException 이 발생해야 한다")
    void winningNumbersContainBonusNumberTest() {
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1,2,3,4,5,6);
        LottoNumber bonusNumber = LottoNumber.valueOf(2);
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLottoNumbers.valueOf(lottoNumbers, bonusNumber));
    }
}
