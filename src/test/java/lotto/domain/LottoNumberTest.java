package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = { 46, 50 })
    @DisplayName("45보다 큰 숫자로 로또넘버 입력")
    void getNumber_outOfRange_exceptThrown(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1이상 45이하의 숫자로 로또넘버 반환")
    void getNumber_returnLottoNumber() {
        int num = 6;
        assertThat(LottoNumber.of(num).getNumber()).isEqualTo(num);
    }
}
