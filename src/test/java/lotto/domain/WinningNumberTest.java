package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    @DisplayName("생성자 검증")
    void constructorDI() {
        assertThatThrownBy(() -> new WinningNumber(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 조회")
    void winningNumber() {
        Lotto lotto = new Lotto(new ArrayList<>(LottoNumber.lottoNumbers().subList(0, 6)));
        assertThat(new WinningNumber(lotto).winningNumber().lottoNumber()).isEqualTo(lotto.lottoNumber());
    }
}
