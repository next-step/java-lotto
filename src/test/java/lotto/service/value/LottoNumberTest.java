package lotto.service.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @RepeatedTest(45)
    @DisplayName("1부터 45까지 로또 번호 정상 생성 검증")
    void create(RepetitionInfo repetitionInfo) {
        Integer number = repetitionInfo.getCurrentRepetition();
        LottoNumber result = LottoNumber.from(number);

        assertThat(result).isEqualTo(LottoNumber.from(number));
    }

    @Test
    @DisplayName("번호가 null인 경우 예외 발생 검증")
    void exception() {
        assertThatNullPointerException().isThrownBy(() -> LottoNumber.from(null));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    @DisplayName("번호가 1보다 작거나 45보다 큰 경우 예외 발생 검증")
    void exception2(Integer number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.from(number));
    }
}
