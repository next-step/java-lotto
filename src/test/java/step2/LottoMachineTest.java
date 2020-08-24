package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoMachine;
import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    @Test
    void lotto_machine() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.makeLotto("")).isInstanceOf(IllegalArgumentException.class); // 공백 입력
        assertThatThrownBy(() -> lottoMachine.makeLotto("만원")).isInstanceOf(IllegalArgumentException.class); // 문자 입력

    }
}
