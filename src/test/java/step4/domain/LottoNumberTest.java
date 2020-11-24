package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("지난 당첨번호, 보너스 번호 빈 값인 경우 ")
    @ValueSource(strings = {"",})
    public void 로또_지난_당첨번호_null(String lottoNumbers) {
        assertThatThrownBy(() -> LottoNumber.of(lottoNumbers, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지난 로또 번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("지난 당첨번호 갯수 6개 이하 또는 이상인 경우 예외처리")
    @ValueSource(strings = {"1,2,3,", "5,6,7,8,9"})
    public void 로또_지난_당첨번호_갯수_유효체크(String lottoNumbers) {
        assertThatThrownBy(() -> LottoNumber.of(lottoNumbers, "8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6보다 작거나 클 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 1 ~ 45사이 아닌 숫자 예외")
    @ValueSource(strings = {"46", "47", "99"})
    public void 로또_번호_45이상_숫자(String lottoNumbers) {
        assertThatThrownBy(() -> LottoNumber.of(lottoNumbers, "8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 ~ 45사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 숫자 아닌 경우 예외")
    @ValueSource(strings = {"가나다라"})
    public void 보너스번호_숫자아닌경우_예외처리(String bonusNumber) {
        assertThatThrownBy(() -> LottoNumber.of("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }
}
