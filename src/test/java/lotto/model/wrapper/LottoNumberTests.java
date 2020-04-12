package lotto.model.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호 테스트")
public class LottoNumberTests {

    @DisplayName("로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 17, 45})
    public void generateLottoNumberTest(int input) {
        assertThatCode(() -> LottoNumber.of(input)).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 비교 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 17, 45})
    public void compareLottoNumberTest(int input) {
        assertThat(LottoNumber.of(input)).isSameAs(LottoNumber.of(input));
    }

    @DisplayName("로또 번호 생성 테스트 - 에러")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void generateLottoNumberExceptionTest(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(input))
                .withMessageContaining("로또 번호는 1 이상, 45 이하여야 합니다.");
    }
}
