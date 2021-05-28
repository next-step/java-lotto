package lotto;

import lotto.exception.BonusNumberException;
import lotto.exception.LottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusNumberTest {
    @DisplayName("보너스 볼 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void createBonusNumber(int bonusNumber) {
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(bonusNumber);
        assertThat(lottoBonusNumber).isEqualTo(new LottoBonusNumber(bonusNumber));
    }

    @DisplayName("당첨 번호에 있는 번호를 입력 시 오류 발생")
    @ParameterizedTest
    @MethodSource("bonusNumberTest")
    void isExistbonusNumberInWinLottoNumber_당첨_로또_번호에_없는_번호_검증(List<Integer> winLotto, int bonusNumber) {
        Lotto lotto = new Lotto(() -> new LottoNumber(winLotto));
        assertThatThrownBy(() -> new LottoBonusNumber(lotto, bonusNumber))
                .isInstanceOf(BonusNumberException.class);
    }

    static Stream<Arguments> bonusNumberTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6)
        );
    }

    @DisplayName("보너스 볼 유효성 체크")
    @ParameterizedTest
    @MethodSource("bonusNumberFormatTest")
    void validateBonusNumber_보너스_번호_유효성_체크(List<Integer> winLotto, int bonusNumber) {
        Lotto lotto = new Lotto(() -> new LottoNumber(winLotto));
        assertThatThrownBy(() -> new LottoBonusNumber(lotto, bonusNumber))
                .isInstanceOf(LottoNumberRangeException.class);
    }

    static Stream<Arguments> bonusNumberFormatTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 55)
        );
    }
}
