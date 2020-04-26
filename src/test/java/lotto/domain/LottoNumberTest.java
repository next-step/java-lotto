package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또 번호 한계값 정상 생성")
    @ParameterizedTest
    @ValueSource(ints = {
            LottoNumber.MIN_LOTTO_NUMBER,
            LottoNumber.MAX_LOTTO_NUMBER
    })
    void create(int number) {
        assertThatCode(() -> LottoNumber.of(number)).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 한계값 벗어날 시 에러")
    @ParameterizedTest
    @ValueSource(ints = {
            LottoNumber.MIN_LOTTO_NUMBER - 1,
            LottoNumber.MAX_LOTTO_NUMBER + 1
    })
    void createFail(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }

}
