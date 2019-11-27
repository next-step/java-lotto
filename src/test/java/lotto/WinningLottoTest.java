package lotto;

import lotto.domain.LottoNum;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    @DisplayName("보너스번호가 이미 생성된 당첨 번호랑 겹치는지 검사")
    @Test
    void checkOverlapTest() {
        String winnginglotto = "1,2,3,4,5,45";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(winnginglotto, new LottoNum(5));
        });
    }
}
