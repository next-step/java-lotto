package step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {
    @Test
    void 로또번호_객체를_생성한다() {
        //Given
        int randomNumber = 39;
        LottoNumber lottoNumber = LottoNumber.from(randomNumber);

        //When
        //Then
        assertThat(lottoNumber.getNumber()).isEqualTo(39);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호가_1보다_작고_45_보다_크면_예외가_발생한다(int num) {
        //Given
        //When
        //Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoNumber.from(num);
                }).withMessageContaining(LottoNumber.ALERT_OUT_OF_RANGE_OF_LOTTO_NUMBER);
    }
}
