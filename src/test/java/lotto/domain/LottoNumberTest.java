package lotto.domain;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    @DisplayName("숫자 생성 테스트")
    void create_number_test(){
        LottoNumber number = LottoNumber.of(1);
        assertThat(number).isEqualTo(LottoNumber.of("1"));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0 , 46})
    @DisplayName("숫자 범위 예외 테스트")
    void validate_range_test(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}