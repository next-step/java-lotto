package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("수동으로 구매하는 번호들은 1 ~ 45를 벗어나는 숫자라면 예외(0 -> IllegalArgumentException, 46 -> IllegalArgumentException)")
    @ValueSource(ints = {0, 46})
    void in_range(int input) {
        assertThatThrownBy(() -> {
            new LottoNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
