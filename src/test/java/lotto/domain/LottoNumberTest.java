package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    void create() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위_벗어난_경우(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(number))
                .withMessageMatching("로또 숫자는 1 이상 45 이하여야 합니다.");
    }

    @Test
    void getNumber() {
        assertThat(new LottoNumber(3).getLottoNumber()).isEqualTo(3);
    }
}
