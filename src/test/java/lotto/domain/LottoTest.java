package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1", "1,2,3,4,5,5", "1,2,3,4,5,6,7"})
    @DisplayName("로또의 개수가 6개가 아니면 에러가 난다.")
    void test(String input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
