package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.LottoNumber;
import step2.exception.InvalidLottoNumberException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호의 범위가 벗어날 경우 에러 발생한다")
    public void lotto_number_bound(int number) {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
            .isThrownBy(() -> {
                new LottoNumber(number);
            }).withMessageMatching("로또 숫자가 유효하지 않습니다");
    }

}
