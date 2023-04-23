package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static step2.LottoRank.*;
import static step2.LottoRankFixture.*;

public class LottoRankTest {

    @ParameterizedTest(name = "입력에 따라 numOfWinner 필드가 잘 증가하는지 테스트")
    @MethodSource("provideNumOfWinner")
    void electWinner_우승자_수_증가(List<Integer> numOfWinner, Map<LottoRank, Integer> expected) {
        electWinner(numOfWinner);
        assertAll(() -> {
            assertThat(MATCH_THREE.numOfWinner()).isEqualTo(expected.get(MATCH_THREE));
            assertThat(MATCH_FOUR.numOfWinner()).isEqualTo(expected.get(MATCH_FOUR));
            assertThat(MATCH_FIVE.numOfWinner()).isEqualTo(expected.get(MATCH_FIVE));
            assertThat(MATCH_SIX.numOfWinner()).isEqualTo(expected.get(MATCH_SIX));
        });
    }

    static Stream<Arguments> provideNumOfWinner() {
        return Stream.of(
                Arguments.arguments(List.of(3, 3, 3), _3개_당첨_3명()),
                Arguments.arguments(List.of(4, 4, 4), _4개_당첨_3명()),
                Arguments.arguments(List.of(5, 5, 5), _5개_당첨_3명()),
                Arguments.arguments(List.of(6, 6, 6), _6개_당첨_3명()),
                Arguments.arguments(List.of(3, 3, 4), _3개_당첨_2명_4개_당첨_1명())
        );
    }


}
