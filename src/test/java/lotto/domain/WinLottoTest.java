package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinLottoTest {

    private final Lotto baseLotto = new Lotto("1, 2, 3, 4, 5, 6");

    @DisplayName("당첨 번호와 보너스가 중복되면 안됨")
    @Test
    void create() {
        assertDoesNotThrow(() -> new WinLotto(baseLotto, LottoNumber.valueOf(7)));
    }

    @DisplayName("당첨 번호와 보너스가 중복됨_실패")
    @Test
    void create_fail() {
        assertThatThrownBy(() -> new WinLotto(baseLotto, LottoNumber.valueOf(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 보너스는 중복될 수 없습니다.");
    }

}
