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
                .hasMessage("로또 숫자 범위가 아닙니다.");
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
                .hasMessage("숫자만 입력해주세요!");
    }

}