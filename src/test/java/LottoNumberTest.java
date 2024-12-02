import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void create() {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
        assertThat(new LottoNumber(3).is(3)).isTrue();
    }

    @Test
    void invalid() {
        assertThatThrownBy(
                () -> new LottoNumber(LottoNumber.MIN_LOTTO_NUMBER - 1)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> new LottoNumber(LottoNumber.MAX_LOTTO_NUMBER + 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
