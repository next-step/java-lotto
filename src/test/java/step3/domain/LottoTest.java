package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또")
public class LottoTest {

    WinningNumbers winningNumbers;

    @BeforeEach
    public void before() {
        winningNumbers = new WinningNumbers(new int[] { 1, 2, 3, 4, 5, 6 }, 7);
    }

    @ParameterizedTest
    @MethodSource("getRankMethodSource")
    public void getRank(int[] nos, Rank rank) {
        Lotto lotto = new Lotto(nos);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(rank);
    }

    private static Stream<Arguments> getRankMethodSource() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 3, 4, 5, 6 }, Rank.FIRST),
                Arguments.of(new int[] { 1, 2, 3, 4, 5, 7 }, Rank.SECOND),
                Arguments.of(new int[] { 1, 2, 3, 4, 5, 9 }, Rank.THIRD),
                Arguments.of(new int[] { 1, 2, 3, 4, 9, 10 }, Rank.FOURTH)
        );
    }

}
