package lotto.domain.lotto;

import lotto.error.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @DisplayName("로또 당첨번호와 보너스 번호는 중복될 수 없다.")
    @Test
    void constructor() {
        final Lotto winningNumbers = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
        final LottoNumber bonusNumber = new LottoNumber(6);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .withMessage(ErrorCode.WINNING_NUMBERS_DUPLICATED.message());
    }
}
