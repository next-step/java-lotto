package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, -1})
    @DisplayName("로또 번호가 1~45 이외의 값이 입력될 경우 예외발생")
    void validateNumber(int input) {
        assertThatThrownBy(()->new LottoNumber(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또 번호는 1과 45사이의 숫자여야 합니다.");
    }
}
