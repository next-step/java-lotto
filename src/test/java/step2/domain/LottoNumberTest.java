package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("지난 당첨번호 빈 값인 경우 ")
    @ValueSource(strings = {"",})
    public void 로또_지난_당첨번호_null(String lottoNumbers) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지난 로또 번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("지난 당첨번호 갯수 6개 이하 또는 이상인 경우 예외처리")
    @ValueSource(strings = {"1,2,3,", "5,6,7,8,9"})
    public void 로또_지난_당첨번호_갯수_유효체크(String lottoNumbers) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6보다 작거나 클 수 없습니다.");
    }
}
