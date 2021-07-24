package lotto.number;

import lotto.helper.Generator;
import lotto.prize.MatchInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.helper.Generator.lottoNumberList;
import static lotto.number.LottoNumbers.NUMBER_OF_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 번호 클래스 테스트")
class WinningNumbersTest {

    @DisplayName("당첨 번호 그룹은 " + NUMBER_OF_LOTTO_NUMBERS + "개의 로또 번호와 보너스 번호를 가지고 생성한다.")
    @Test
    void initLottoNumbers() {
        List<LottoNumber> lottoNumbers = lottoNumberList(1, 2, 3, 4, 5, 6);

        assertThat(WinningNumbers.of(lottoNumbers, LottoNumber.from(7))).isNotNull();
    }

    @DisplayName("당첨 번호 생성시 번호 수가 " + NUMBER_OF_LOTTO_NUMBERS + "개가 아니거나 null 이 올 경우 예외를 던진다.")
    @NullSource
    @MethodSource
    @ParameterizedTest
    void initLottoNumbersException(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() -> LottoNumbers.from(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> initLottoNumbersException() {
        return Stream.of(
                Arguments.of(lottoNumberList(1, 2, 3, 4, 5)),
                Arguments.of(lottoNumberList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("로또 번호와 당첨 번호를 가지고 몇개의 번호가 일치하는지 반환한다.")
    @MethodSource
    @ParameterizedTest
    void matchCount(LottoNumbers lottoNumbers, MatchInfo matchInfo) {
        WinningNumbers winningNumbers = Generator.winningNumbers(31, 5, 10, 15, 20, 25, 30);

        assertThat(winningNumbers.match(lottoNumbers)).isEqualTo(matchInfo.matchCount());
    }


    private static Stream<Arguments> matchCount() {
        return Stream.of(
                Arguments.of(Generator.lottoNumbers(5, 10, 15, 20, 25, 30), 6),
                Arguments.of(Generator.lottoNumbers(5, 10, 15, 20, 25, 31), 5),
                Arguments.of(Generator.lottoNumbers(5, 10, 15, 20, 26, 31), 4),
                Arguments.of(Generator.lottoNumbers(5, 10, 15, 21, 26, 31), 3),
                Arguments.of(Generator.lottoNumbers(5, 10, 16, 21, 26, 31), 2),
                Arguments.of(Generator.lottoNumbers(5, 11, 16, 21, 26, 31), 1),
                Arguments.of(Generator.lottoNumbers(6, 11, 16, 21, 26, 31), 0)
        );
    }

    @DisplayName("당첨 번호는 중복이 있어서는 안된다. 중복이 있을 경우 예외를 발생 시킨다.")
    @MethodSource
    @ParameterizedTest
    void duplicationCheck(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        assertThatThrownBy(() -> WinningNumbers.of(lottoNumbers, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> duplicationCheck() {
        return  Stream.of(
                Arguments.of(lottoNumberList(1, 2, 3, 4, 5, 5), LottoNumber.from(7)),
                Arguments.of(lottoNumberList(1, 2, 3, 4, 5, 6), LottoNumber.from(6)),
                Arguments.of(lottoNumberList(1, 2, 3, 4, 5, 5), LottoNumber.from(5))
        );
    }
}
