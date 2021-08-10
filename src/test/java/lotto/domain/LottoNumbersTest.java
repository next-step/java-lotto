package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @DisplayName("로또 번호가 6개가 아니거나 중복된 로또번호를 포함 시 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("wrongLottoNumbersParameterProvider")
    void create_ThrowsIllegalArgumentException_IfInputSizeIsNotSixOr(List<LottoNumber> lottoNumbers) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumbers(lottoNumbers));
    }

    @DisplayName("로또 번호 당첨번호 체크")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("lottoNumbersParameterProvider")
    void check_ReturnLottoStatus_IfInputIsWinningNumbers(List<LottoNumber> inputLottoNumbers, LottoStatus expected) {
        LottoNumbers lottoNumbers = new LottoNumbers(inputLottoNumbers);
        LottoNumbers winningNumbers = new LottoNumbers(makeLottoNumbers(1, 7, 15, 28, 36, 45));
        LottoStatus lottoStatus = lottoNumbers.check(winningNumbers);
        assertThat(lottoStatus).isEqualTo(expected);
    }



    private static List<LottoNumber> makeLottoNumbers(Integer... integers) {
        return Arrays.stream(integers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    static Stream<Arguments> wrongLottoNumbersParameterProvider() {
        return Stream.of(
                Arguments.of(makeLottoNumbers(2, 6, 16, 24, 36)),
                Arguments.of(makeLottoNumbers(5, 9, 17, 28, 34, 37, 45)),
                Arguments.of(makeLottoNumbers(5, 9, 17, 17, 34, 37))
        );
    }

    static Stream<Arguments> lottoNumbersParameterProvider() {
        return Stream.of(
                Arguments.of(makeLottoNumbers(1, 7, 15, 28, 36, 45), LottoStatus.FIRST),
                Arguments.of(makeLottoNumbers(1, 7, 15, 28, 36, 43), LottoStatus.SECOND),
                Arguments.of(makeLottoNumbers(1, 7, 15, 28, 30, 43), LottoStatus.THIRD),
                Arguments.of(makeLottoNumbers(1, 7, 15, 24, 30, 43), LottoStatus.FOURTH),
                Arguments.of(makeLottoNumbers(1, 7, 12, 24, 30, 43), LottoStatus.NOTHING),
                Arguments.of(makeLottoNumbers(1, 3, 12, 24, 30, 43), LottoStatus.NOTHING)
        );
    }


}
