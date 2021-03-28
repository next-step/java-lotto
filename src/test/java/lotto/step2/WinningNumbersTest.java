package lotto.step2;

import lotto.step2.domain.WinningNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @ParameterizedTest(name = "보너스_번호_중복_Test")
    @MethodSource("보너스_번호_중복_Provider")
    public void 보너스_번호_중복_Test(String[] inputLottoNumbers, int inputBonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(inputLottoNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 6개 로또 번호와 다른 숫자여야 합니다.");
    }

    static Stream<Arguments> 보너스_번호_중복_Provider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "4", "5", "7", "3", "15"}, 15)
        );
    }


    @ParameterizedTest(name = "보너스_번호_범위_Test")
    @MethodSource("보너스_번호_범위_Provider")
    public void 보너스_번호_범위_Test(String[] inputLottoNumbers, int inputBonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(inputLottoNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효범위를 벗어난 숫자입니다.");
    }

    static Stream<Arguments> 보너스_번호_범위_Provider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "4", "5", "7", "3", "15"}, -3)
        );
    }

    @ParameterizedTest(name = "보너스_번호_타입_Test")
    @MethodSource("보너스_번호_타입_Provider")
    public void 보너스_번호_타입_Test(String[] inputLottoNumbers, String inputBonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(inputLottoNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 정수여야 합니다.");
    }

    static Stream<Arguments> 보너스_번호_타입_Provider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "4", "5", "7", "3", "15"}, "a")
        );
    }
    
}
