package lotto.domain.lotto;

import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0, 46, 47, 48})
    @DisplayName("인스턴스 생성시 lottoNumber가 MIN_LOTTO_NUMBER 보다 크거나 같고 MAX_LOTTO_NUMBER 보다 작거나 같은 정수가 아닌 경우 InvalidLottoNumberException이 발생한다.")
    void testInstanceCreationFailCase(int lottoNumber) {
        assertThatThrownBy(() -> LottoNumber.valueOf(lottoNumber))
                .isExactlyInstanceOf(InvalidLottoNumberException.class);
    }
}
