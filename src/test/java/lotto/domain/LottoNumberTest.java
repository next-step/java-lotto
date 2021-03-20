package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("보너스번호 생성 테스트")
    public void bonusNumberTest() throws Exception {
        //given
        int inputNumber = 1;
        LottoNumber bonusNumber = new LottoNumber(inputNumber);

        //when

        //then
        assertThat(bonusNumber).isEqualTo(inputNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,45})
    @DisplayName("보너스번호 범위 1~45 테스트")
    public void bonusNumberRangeTest(int inputNumber) throws Exception {
        //given
        LottoNumber bonusNumber = new LottoNumber(inputNumber);

        //when

        //then
        assertThat(bonusNumber).isEqualTo(inputNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    @DisplayName("잘못된 보너스번호 예외 테스트")
    public void bonusNumberRangeExceptionTest(int inputNumber) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(inputNumber);
        });
        //then
    }
}
