package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("로또 번호가 같으면 서로 같은 객체여야 한다.")
    @Test
    void equalsAndHashCode() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("로또 번호에 적합하지 않은 숫자로 로또 번호 객체를 생성하면, 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create_givenWrongNumber(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(value));
    }

}
