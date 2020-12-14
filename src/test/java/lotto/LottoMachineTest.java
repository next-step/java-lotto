package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또머신에서 번호 생성 테스트")
    void generate_lotto_numbers_test() {
        // given
        LottoMachine.getInstance();

        // when & then
        assertThat(LottoMachine.generateLottoNumber().size()).isEqualTo(6);
    }
}
