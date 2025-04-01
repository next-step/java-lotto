package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    @DisplayName("당첨번호를 통해서 몇개 맞추었는지 확인한다.")
    void lottoMatchTest(int matchedCount) {
        var lotto = new Game(List.of(1, 2, 3, 4, 5, 6));
        var winningNumbers = makeWinningNumbers(matchedCount);

        var result = lotto.countMatches(winningNumbers);

        Assertions.assertThat(result).isEqualTo(matchedCount);
    }

    private static List<Integer> makeWinningNumbers(int matchedCount) {
        return IntStream.rangeClosed(1, 6)
                .mapToObj(i -> i > matchedCount ? 99 : i)
                .collect(Collectors.toUnmodifiableList());
    }
}
