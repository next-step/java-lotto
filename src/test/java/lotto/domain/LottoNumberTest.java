package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("배열이 null이면 예외")
    @NullSource
    void if_null(List<Integer> nullList) {
        assertThatThrownBy(() -> {
            new LottoNumber(nullList);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
