package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoNumber.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    public void create() {
        assertThat(of("8")).isEqualTo(of(8));
        assertThat(of("8") == of(8)).isTrue();
    }

    @Test
    public void create_hasSpace() {
        assertThat(of("8 ")).isEqualTo(of(8));
    }

    @Test
    public void create_1보다_작은_값() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            of(0);
        });
    }

    @Test
    public void create_45보다_큰_값() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            of(46);
        });
    }

    @Test
    public void create_null() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            of(null);
        });
    }
}
