package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRoundMachineTest {
    @DisplayName("로또 번호 생성 테스트, 검증된 라이브러리만 사용하여 LottoNumber 객체 생성만 확인")
    @Test
    public void lottoNumber() throws Exception {
        Assertions.assertThat(LottoMachine.generateLottoNumber())
                .isNotNull();
    }
}