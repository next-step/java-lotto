package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    void 보너스번호와_당첨번호_중복시_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(3));
        }).withMessageContaining("보너스번호는 당첨번호에 포함되지 않는 번호입니다.");
    }

}
