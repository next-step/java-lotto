package lotto;

import lotto.utile.StringUtile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringUtileTest {
    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:4", "2:14", "3:24", "4:27", "5:40"}, delimiter = ':')
    @DisplayName("로또번호 문자열을 스플릿 후 int배열 변환 테스트")
    void convertStringToIntTest(int index, int number) {
        String lottoNumber = "2, 4, 14, 24, 27, 40";
        int[] arrLottoNumber = StringUtile.convertStringToInt(lottoNumber);
        Assertions.assertThat(arrLottoNumber[index]).isEqualTo(number);
    }

    @Test
    @DisplayName("로또번호 문자열 빈 문자열 예외처리 테스트")
    void convertStringToIntTest_checkEmptyString() {
        String lottoNumber = "";
        Assertions.assertThatThrownBy(() -> {
                    StringUtile.convertStringToInt(lottoNumber);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호가 비어있습니다.");
    }

    @Test
    @DisplayName("로또번호 문자열의 로또 번호 개수가 6개를 초과할 경우")
    void convertStringToIntTest_checkLotOfNumber() {
        String lottoNumber = "2, 4, 14, 24, 27, 40, 41";
        Assertions.assertThatThrownBy(() -> {
                    StringUtile.convertStringToInt(lottoNumber);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호를 6개 입력해주시기 바랍니다.");
    }

    @Test
    @DisplayName("로또번호 문자열에 45를 넘는 값이 있는경우")
    void convertStringToIntTest_checkOverThen45() {
        String lottoNumber = "2, 4, 14, 24, 27, 46";
        Assertions.assertThatThrownBy(() -> {
                    StringUtile.convertStringToInt(lottoNumber);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호는 1부터 45까지의 숫자로 입력해주시기 바랍니다.");
    }

    @Test
    @DisplayName("로또번호 문자열에 1보다 낮은값이 있는 경우")
    void convertStringToIntTest_checkSmallThanOne() {
        String lottoNumber = "2, 4, 14, 24, 27, 0";
        Assertions.assertThatThrownBy(() -> {
                    StringUtile.convertStringToInt(lottoNumber);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호는 1부터 45까지의 숫자로 입력해주시기 바랍니다.");
    }

    @Test
    @DisplayName("로또번호 문자열에 문자가 들어있는 경우")
    void convertStringToIntTest_checkIsNumber() {
        String lottoNumber = "2, 4, 14, a, 27, 40";
        Assertions.assertThatThrownBy(() -> {
                    StringUtile.convertStringToInt(lottoNumber);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호는 숫자로 입력해주시기 바랍니다.");
    }

}
