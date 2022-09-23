package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTest {

    @DisplayName("1 이상 45 이하의 번호는 생성이 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 30, 45})
    void createLotto(int input) {
        assertDoesNotThrow(() -> new LottoNumber(input));
    }

    @DisplayName("1 미만의 수 또는 45 초과 번호를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 47})
    void createLottoWhenInputNumberLessThanOne(int input) {
        assertThatThrownBy(() -> new LottoNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 끼리 비교할 수 있다.")
    @Test
    void equals() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}
