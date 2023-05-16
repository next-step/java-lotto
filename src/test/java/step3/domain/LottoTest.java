package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("당첨 숫자와 구매한 로또의 숫자가 일치하는 수를 반환한다.")
    @ParameterizedTest
    @MethodSource("getResultParameters")
    public void getResultTest(List<Integer> purchasedNumbers, List<Integer> winningNumbers, int expected) {
        assertThat(new Lotto(purchasedNumbers).countMatched(winningNumbers)).isEqualTo(expected);
    }

    private static Stream<Arguments> getResultParameters() {
        return Stream.of(
                Arguments.of(List.of(11, 21, 31, 41, 51, 61), List.of(10, 22, 33, 44, 55, 66), 0),
                Arguments.of(List.of(11, 21, 31, 41, 51, 61), List.of(9, 11, 12, 13, 14, 15), 1),
                Arguments.of(List.of(11, 21, 31, 41, 51, 61), List.of(9, 11, 12, 13, 14, 21), 2),
                Arguments.of(List.of(11, 21, 31, 41, 51, 61), List.of(9, 11, 12, 13, 21, 31), 3),
                Arguments.of(List.of(11, 21, 31, 41, 51, 61), List.of(9, 11, 21, 22, 31, 41), 4),
                Arguments.of(List.of(11, 21, 31, 41, 51, 61), List.of(9, 11, 21, 31, 41, 61), 5),
                Arguments.of(List.of(11, 21, 31, 41, 51, 61), List.of(11, 21, 31, 41, 51, 61), 6)
        );
    }
}