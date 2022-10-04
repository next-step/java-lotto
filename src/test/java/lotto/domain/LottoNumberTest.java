package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("null 또는 빈 값일 경우 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_create_lotto(final String input) {

        assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null 또는 빈 공백 입니다.");

    }

    @DisplayName("입력받은 로또 번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void create_lotto(final int index) {

        final LottoNumber lottoNumber = LottoNumber.from("1, 2, 3, 4, 5, 6");
        final List<Number> result = lottoNumber.getLottoNumber();

        assertThat(result).contains(new Number(index));
    }
}
