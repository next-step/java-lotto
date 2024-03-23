package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.error.SizeExceedLottoNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    private LottoNumber[] values;

    @BeforeEach
    public void beforeEach() {
        values = LottoNumber.values();
    }

    @Test
    @DisplayName("로또번호는 1부터 45까지의 범위의 값만 가질수 있다")
    public void Lotto_Number_Should_Have_Values_1_To_45() {
        assertThat(values)
            .extracting(LottoNumber::getLottoNumber)
            .allSatisfy(lottoNumber -> assertThat(lottoNumber).isBetween(1, 45));
    }

    @ParameterizedTest
    @ValueSource(ints = {-47, -1, 46, 47})
    @DisplayName("로또번호가 1부터 45의 범위가 아닌 경우 예외가 발생한다")
    public void If_Lotto_Number_Not_In_range1_to_45_Occurs_Exception(int input) {
        assertThatThrownBy(() -> LottoNumber.formInt(input))
            .isInstanceOf(SizeExceedLottoNumberException.class)
            .hasMessage("로또 번호는 1부터 45의 범위만 가능합니다. 입력값: " + input);
    }
}
