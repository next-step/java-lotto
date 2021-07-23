package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("로또 숫자 테스트")
class LottoNumberTest {

    @DisplayName("로또 숫자는 1 ~ 45 숫자로만 초기화 가능하다")
    @ValueSource(ints = {1, 25, 45})
    @ParameterizedTest
    void initLottoNumber(int number) {
        assertThat(LottoNumber.from(number)).isNotNull();
    }
}
