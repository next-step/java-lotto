package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @ParameterizedTest
    @MethodSource(value = "createMatchSource")
    void matchesTest(List<String> lotto, List<String> winnerLotto, int matchCount) {
        assertThat(Lotto.from(lotto).matchWinLotto(Lotto.from(winnerLotto))).isEqualTo(LottoRank.valueOfMatchCount(matchCount));
    }

    static Stream<Arguments> createMatchSource() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("1", "2", "3", "5", "31", "17"),
                        Arrays.asList("1", "2", "3", "5", "6", "7"),
                        4
                ),
                Arguments.of(
                        Arrays.asList("1", "2", "3", "5", "31", "17"),
                        Arrays.asList("1", "2", "3", "5", "31", "17"),
                        7
                ),
                Arguments.of(
                        Arrays.asList("11", "12", "13", "15", "32", "27"),
                        Arrays.asList("1", "2", "3", "5", "31", "17"),
                        0
                )
        );
    }

    @ParameterizedTest
    @MethodSource(value = "createLottoSource")
    void generateErrorTest(List<String> input) {
        assertThatThrownBy(() -> Lotto.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<String>> createLottoSource() {
        return Stream.of(
                Arrays.asList("1", "2", "3", "5", "7"),
                Arrays.asList("1", "2", "3", "5", "6", "7", "8", "9"),
                Arrays.asList("")
        );
    }
}
