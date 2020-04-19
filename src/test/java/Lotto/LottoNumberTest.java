package Lotto;

import Lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("Number 생성 테스트")
    void createNewNumber() {
        final int number = 24;
        final LottoNumber lottoNumber = LottoNumber.from(number);
        assertThat(lottoNumber).isEqualTo(LottoNumber.from(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, 70})
    @DisplayName("Number 생성시 특정 값을 만들 때 에러 발생")
    void ErrorWhenCreateNumberWithOuterNumber(final int number) {
        assertThatThrownBy(() -> {
            LottoNumber.from(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
