package lotto.domain;

import lotto.domain.numbergenerator.LottoNumbersGenerator;
import lotto.domain.numbergenerator.ManualLottoNumbersGenerator;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoNumbersCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoNumbersGeneratorTest {

    @Test
    @DisplayName("입력한 문자열에 해당하는 로또번호가 생성 된다.")
    void manualLottoGenerateTest() {
        LottoNumbersGenerator manualLottoNumbersGenerator = ManualLottoNumbersGenerator.from(new String[] {"1", "2", "3", "4", "5", "6"});
        List<LottoNumber> generate = manualLottoNumbersGenerator.generate();

        assertThat(generate.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("입력한 문자열이 6개가 아니라면 예외")
    @MethodSource
    void lottoNumbersCountException(String[] strings) {
        assertThatThrownBy(() -> ManualLottoNumbersGenerator.from(strings)).isInstanceOf(LottoNumbersCountException.class);
    }

    static Stream<Arguments> lottoNumbersCountException() {
        return Stream.of(
                Arguments.of(
                        (Object) new String[] {}
                ),
                Arguments.of(
                        (Object) new String[] {"1", "2", "3"}
                ),
                Arguments.of(
                        (Object) new String[] {"1", "2", "3", "4", "5", "6", "7"}
                )
        );
    }

    @ParameterizedTest
    @DisplayName("입력한 문자열중 로또 번호가 아니라면 예외")
    @MethodSource
    void manualLottoNumberException(String[] strings) {
        assertThatThrownBy(() -> ManualLottoNumbersGenerator.from(strings)).isInstanceOf(LottoNumberException.class);
    }

    static Stream<Arguments> manualLottoNumberException() {
        return Stream.of(
                Arguments.of(
                        (Object) new String[] {"0", "1", "2", "3", "4", "5"}
                ),
                Arguments.of(
                        (Object) new String[] {"0", "-1", "-2", "-3", "-4", "-5"}
                ),
                Arguments.of(
                        (Object) new String[] {"46", "47", "48", "49", "50", "51", "52"}
                )
        );
    }
}