package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @ParameterizedTest
    @MethodSource("getWinningNumber")
    void checkLotto(List<Integer> winningNumber, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int matchNumber = lotto.checkLotto(winningNumber);

        assertThat(matchNumber).isEqualTo(expected);
    }

    private static Stream<Arguments> getWinningNumber() {
        List<Integer> all = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> none = List.of(11, 12, 13, 14, 15, 16);
        List<Integer> half = List.of(1, 2, 3, 14, 15, 16);
        return Stream.of(
                Arguments.of(all, 6),
                Arguments.of(none, 0),
                Arguments.of(half, 3)
        );
    }
}
