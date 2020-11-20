package step2.lotto.automatic.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMatchTest {

    private static LottoMatch lottoMatchTest;

    @Test
    public void 금액_음수_입력_체크() {
        assertThatThrownBy(() ->
                lottoMatchTest = new LottoMatch(-1)
        ).isInstanceOf(RuntimeException.class);
    }

}
