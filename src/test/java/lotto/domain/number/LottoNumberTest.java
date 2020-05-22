package lotto.domain.number;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @DisplayName("Lotto 번호가 1 ~ 45 사이의 값이 아니면 IllegalArgumentException Throw")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void lottoNumberThrowException(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(number))
                .withMessage("로또 번호는 1 ~ 45 사이의 값이어야 합니다. - " + number);
    }
}