package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또 번호(원시값)의 포장 객체 생성")
    void create(int number) {
        assertNotNull(LottoNumber.valueOf(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("로또 번호 유효성 검사")
    void create_validate(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.valueOf(number));
    }
}
