package lotto.number;

import lotto.helper.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.helper.Generator.lottoNumberList;
import static lotto.number.LottoNumbers.NUMBER_OF_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 번호 그룹 테스트")
class LottoNumbersTest {

    @DisplayName("로또 번호 그룹은 " + NUMBER_OF_LOTTO_NUMBERS + "개의 로또 번호가지고 생성한다.")
    @Test
    void initLottoNumbers() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, NUMBER_OF_LOTTO_NUMBERS)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());

        assertThat(LottoNumbers.from(lottoNumbers)).isNotNull();
    }

    @DisplayName("로또 번호 생성시에 번호 수가" + NUMBER_OF_LOTTO_NUMBERS + "개가 아닌 경우나 null 이 올 경우 예외를 던진다.")
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
    void matchCount(LottoNumbers lottoNumbers, int expectedMatchCount) {
        WinningNumbers winningNumbers = Generator.winningNumbers(31, 5, 10, 15, 20, 25, 30);

        assertThat(lottoNumbers.match(winningNumbers)).isEqualTo(expectedMatchCount);
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

    @DisplayName("로또 번호는 중복이 있어서는 안된다. 중복이 있을 경우 예외를 발생 시킨다.")
    @Test
    void duplicationCheck() {
        List<LottoNumber> lottoNumbers = lottoNumberList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> LottoNumbers.from(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

}
