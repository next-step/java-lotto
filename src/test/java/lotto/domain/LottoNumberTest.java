package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("번호")
public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1,45})
    @DisplayName("번호 범위 1~45 테스트")
    public void numberRangeTest(int inputNumber) throws Exception {
        //given
        LottoNumber number = new LottoNumber(inputNumber);

        //when

        //then
        assertThat(number).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    @DisplayName("잘못된 번호 예외 테스트")
    public void numberRangeExceptionTest(int inputNumber) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(inputNumber);
        });
        //then
    }
}
