package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoMachineTest {

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void generate_lotto_numbers_test() {
        LottoMachine.getInstance();
        assertEquals(6, LottoMachine.generateLottoNumber().size());
    }

}
