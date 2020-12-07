package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    public void invalid_로또_번호_범위() {
        assertThat(LottoNumber.of(1).getNumber()).isEqualTo(1);

        assertThatThrownBy(() -> {
            LottoNumber.of(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
