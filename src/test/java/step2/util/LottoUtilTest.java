package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoUtilTest {

    @ParameterizedTest
    @DisplayName("로또 구매 값 0인 경우 예외")
    @ValueSource(ints = {0})
    public void 로또_구매값_0원(int value) {
        assertThatThrownBy(() -> LottoUtil.purchaseAmountValidate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액 값이 없습니다.");

    }

    @ParameterizedTest
    @DisplayName("로또 구매 값 1000원 이하인 경우 예외")
    @ValueSource(ints = {100, 200, 500})
    public void 로또_구매값_1000원이하(int value) {
        assertThatThrownBy(() -> LottoUtil.purchaseAmountValidate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1000원부터 입력가능합니다.");

    }

    @ParameterizedTest
    @DisplayName("지난 당첨번호 빈 값인 경우 ")
    @ValueSource(strings = {"", })
    public void 로또_지난_당첨번호_null(String lottoNumbers) {
        assertThatThrownBy(() -> LottoUtil.lottoNumberSizeValidate(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지난 로또 번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @DisplayName("지난 당첨번호 갯수 6개 이하 또는 이상인 경우 예외처리")
    @ValueSource(strings = {"1,2,3,", "5,6,7,8,9"})
    public void 로또_지난_당첨번호_갯수_유효체크(String lottoNumbers) {
        assertThatThrownBy(() -> LottoUtil.lottoNumberSizeValidate(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6보다 작거나 클 수 없습니다.");
    }
}
