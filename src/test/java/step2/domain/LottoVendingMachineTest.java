package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoVendingMachineTest {
    @DisplayName("makeLottoNumberWithTimes 자동생성: 시도횟수와 기록의 길이가 같아야 함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @ValueSource(ints = {1, 10})
    void makeLottoNumberWithTimesByRandom(int numberOfLotto) {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        List<LottoNumber> gambleHistory = lottoVendingMachine.makeLottoNumberWithTimes(new RandomGenerator(), numberOfLotto);
        assertThat(gambleHistory.size()).isEqualTo(numberOfLotto);
    }

    static Stream<Arguments> makeLottoNumberWithTimesByManualParam() {
        return Stream.of(
                Arguments.arguments(
                        1,
                        new ArrayList<>(Arrays.asList(
                                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))
                        ))
                ),
                Arguments.arguments(
                        5,
                        new ArrayList<>(Arrays.asList(
                                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16)),
                                new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25, 26)),
                                new ArrayList<>(Arrays.asList(31, 32, 33, 34, 35, 36)),
                                new ArrayList<>(Arrays.asList(45, 44, 43, 42, 41, 40))
                        ))
                )
        );
    }

    @DisplayName("makeLottoNumberWithTimes 수동생성: 시도횟수와 기록의 길이가 같아야 함")
    @ParameterizedTest(name = "{displayName} {index} 수동로또 횟수: {0} |수동번호: {1}")
    @MethodSource("makeLottoNumberWithTimesByManualParam")
    void makeLottoNumberWithTimesByManual(int numberOfLotto, List<List<Integer>> manualLottoNumberInput) {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        List<LottoNumber> gambleHistory = lottoVendingMachine.makeLottoNumberWithTimes(new ManualGenerator(manualLottoNumberInput), numberOfLotto);
        assertThat(gambleHistory.size()).isEqualTo(numberOfLotto);
    }
}