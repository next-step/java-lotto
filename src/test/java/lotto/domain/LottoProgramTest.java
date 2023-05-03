package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class LottoProgramTest {
    @Test
    @DisplayName("구입금액으로 로또 장수 파악")
    void numberOfLotto() {
        int cost = 14000;
        int expected = 14;

        LottoProgram program = new LottoProgram(cost, new LottoCreatingRandomStrategy());
        assertThat(program.getNumberOfLotto()).isEqualTo(expected);
    }

    @Test
    @DisplayName("구입금액이 음수인지 체크")
    void validate() {
        assertThatThrownBy(() -> {
            new LottoProgram(-14000, new LottoCreatingRandomStrategy());
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입금액이 로또 한장 가격보다 작을 수 없습니다.");
    }
}
