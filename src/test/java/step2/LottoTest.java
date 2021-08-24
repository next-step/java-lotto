package step2;

import org.junit.jupiter.api.Test;
import step2.model.Lotto;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    public void 로또번호_빈문자() {
        assertThatThrownBy(() -> new Lotto(""))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또번호_숫자아님() {
        assertThatThrownBy(() -> new Lotto("number1 number2 3 4 5 6"))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또번호_6개_아님() {
        assertThatThrownBy(() -> new Lotto("number1 number2 3 4 5"))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또번호_중복() {
        assertThatThrownBy(() -> new Lotto("1 3 3 4 5"))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또번호_범위_벗어남() {
        assertThatThrownBy(() -> new Lotto("1 2 3 4 55"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
