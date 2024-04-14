package lottoTest;

import lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호는 당첨번호와 중복될 수 없다")
    void BONUS_NUMBER_NOT_DUPLICATED_WITH_WINNING_NUMBER(){
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() ->WinningLotto.of( new String[]{"1","2","3","4","5","6"}, "6"));
    }
}
