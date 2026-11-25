package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("로또와 당첨 번호가 몇 개 일치하는지 센다")
    @ParameterizedTest(name = "{0} 이면 {1}개 일치")
    @MethodSource("purchasedAndMatchCount")
    void matchCount(List<Integer> purchased, int expected) {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.matchCount(new Lotto(purchased))).isEqualTo(expected);
    }

    static Stream<Arguments> purchasedAndMatchCount() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 0));
    }
}
