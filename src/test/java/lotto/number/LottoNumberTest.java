package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @DisplayName("숫자 데이터가 아닌 경우 에러를 발생합니다.")
    @Test
    public void testIfNotNumbericDataThenInvokeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of("string"));
    }

    @DisplayName("숫자가 1보다 작거나 45 보다 크면 에러를 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "55"})
    public void testIfNotBetween1And45ThenInvokeException(String number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }

    @DisplayName("동일한 숫자 값으로 인스턴스를 얻었을 때, 주소가 동일한 인스턴스여야 합니다.")
    @Test
    public void testIfInputSameDataThenSameObject() {
        String data1 = "1";
        String data2 = "1";

        assertThat(LottoNumber.of(data1)).isSameAs(LottoNumber.of(data2));
    }
}
