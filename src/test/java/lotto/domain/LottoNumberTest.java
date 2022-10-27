package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또_번호_객체_생성(int value) {
        Assertions.assertThat(new LottoNumber(value)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호_객체_생성_범위초과(int value) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
