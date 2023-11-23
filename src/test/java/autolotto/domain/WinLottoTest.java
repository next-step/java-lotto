package autolotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinLottoTest {
    @Test
    @DisplayName("보너스 당첨번호 중복확인")
    void winLotto_보너스당첨번호중복() {
        Assertions.assertThatThrownBy(()-> new WinLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNo(2)))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
