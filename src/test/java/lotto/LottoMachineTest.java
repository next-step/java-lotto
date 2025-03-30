package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @DisplayName("로또 번호 생성 테스트")
    @Test
    public void lottoNumber() throws Exception {
        // size 를 max 값과 동일하게 맞춰 전체 number list 확인
        LottoMachine lottoMachine = new LottoMachine(new LottoNumbersCondition(1, 5, 5));
        Assertions.assertThat(lottoMachine.generateLottoNumber().getNumbers())
                .hasSize(5)
                .containsExactly(1, 2, 3, 4, 5);
    }
}