package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호가 1-45 사이가 아니면 에러를 던진다")
    void name(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

}
