package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.Fixtures.makeLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    @DisplayName("당첨번호와 보너스번호 중복 시 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfWinningNumberAndBonusNumberAreDuplicate() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningNumbers(new LottoNumbers(makeLottoNumbers(1, 7, 15, 28, 36, 45)),
                        new LottoNumber(1)));
    }

    @DisplayName("당첨 결과 확인")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("lottoNumbersParameterProvider")
    void checkWinning_ReturnLottoStatus_IfInputIsLottoNumbers(List<LottoNumber> inputLottoNumbers, LottoStatus expected) {
        LottoNumbers winningLottoNumbers = new LottoNumbers(makeLottoNumbers(1, 7, 15, 28, 36, 45));
        WinningNumbers winningNumbers = new WinningNumbers(winningLottoNumbers, new LottoNumber(10));

        LottoNumbers lottoNumbers = new LottoNumbers(inputLottoNumbers);
        LottoStatus lottoStatus = winningNumbers.checkWinning(lottoNumbers);
        assertThat(lottoStatus).isEqualTo(expected);

    }

    static Stream<Arguments> lottoNumbersParameterProvider() {
        return Stream.of(
                Arguments.of(makeLottoNumbers(1, 7, 15, 28, 36, 45), LottoStatus.FIRST),
                Arguments.of(makeLottoNumbers(1, 7, 15, 28, 36, 10), LottoStatus.SECOND),
                Arguments.of(makeLottoNumbers(1, 7, 15, 28, 36, 43), LottoStatus.THIRD),
                Arguments.of(makeLottoNumbers(1, 7, 15, 28, 30, 10), LottoStatus.FOURTH),
                Arguments.of(makeLottoNumbers(1, 7, 15, 24, 30, 43), LottoStatus.FIFTH),
                Arguments.of(makeLottoNumbers(1, 7, 12, 24, 30, 43), LottoStatus.NOTHING),
                Arguments.of(makeLottoNumbers(1, 3, 12, 24, 30, 10), LottoStatus.NOTHING)
        );
    }

}
