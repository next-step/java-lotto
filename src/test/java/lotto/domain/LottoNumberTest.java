package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("LottoNumber 번호 범위 테스트")
    void lottoNumberRangeTest(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(input + "번은 로또 숫자 범위가 아닙니다. (1 - 45 사이만 입력해주세요.)");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "45"})
    @DisplayName("LottoNumber 숫자 수동 입력 테스트")
    void createManualLottoNumberTest(String input) {
        LottoNumber manualLottoNumber = LottoNumber.createManualLottoNumber(input);

        LottoNumber lottoNumber = new LottoNumber(Integer.parseInt(input));

        assertThat(manualLottoNumber)
                .usingRecursiveComparison()
                .isEqualTo(lottoNumber);
    }

    @Test
    @DisplayName("LottoNumber 숫자가 아닐 때 에러 리턴 테스트")
    void notNumberErrorTest() {
        assertThatThrownBy(() -> LottoNumber.createManualLottoNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("a는 숫자가 아닙니다. 숫자만 입력해주세요!");
    }

    @Test
    @DisplayName("LottoNumber 같음 테스트")
    void sameLottoNumberTest() {
        LottoNumber manualLottoNumber = LottoNumber.createManualLottoNumber("3");
        LottoNumber bonusLottoNumber = LottoNumber.createManualLottoNumber("3");

        assertThat(manualLottoNumber)
                .isEqualTo(bonusLottoNumber);
    }

}