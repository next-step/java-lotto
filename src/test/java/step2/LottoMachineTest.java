package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoMachine;
import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    @Test
    void lotto_machine() {
        assertThatThrownBy(() -> LottoMachine.getCount("")).isInstanceOf(IllegalArgumentException.class); // 공백 입력
        assertThatThrownBy(() -> LottoMachine.getCount("만원")).isInstanceOf(IllegalArgumentException.class); // 문자 입력
        assertThatThrownBy(() -> LottoMachine.getCount("1001")).isInstanceOf(IllegalArgumentException.class); // 단위 오류 입력

    }
}
