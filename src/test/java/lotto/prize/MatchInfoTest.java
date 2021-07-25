package lotto.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 번호화 로또 번호를 비교한 정보를 담는 클래스 테스트")
class MatchInfoTest {

    @DisplayName("매치 카운트와 보너스 매칭 여부를 가지고 초기화 한다.")
    @MethodSource
    @ParameterizedTest
    void init(int matchCount, boolean bonusMatch, MatchInfo expectedMatchInfo) {
        assertThat(MatchInfo.of(matchCount, bonusMatch)).isEqualTo(expectedMatchInfo);
    }

    private static Stream<Arguments> init() {
        return Stream.of(
                Arguments.of(5, true, MatchInfo.of(5, true)),
                Arguments.of(5, false, MatchInfo.of(5, false))
        );
    }

    @DisplayName("매치 카운트를 전달받아 동일한 값인지 비교한다.")
    @MethodSource
    @ParameterizedTest
    void isCountEqual(int count, boolean expectedValue) {
        MatchInfo matchInfo = MatchInfo.of(5, true);

        assertThat(matchInfo.isCountEqual(count)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isCountEqual() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(10, false)
        );
    }

    @DisplayName("매치 카운트를 전달받아 그 값보다 작은값인지 비교한다.")
    @MethodSource
    @ParameterizedTest
    void isCountUnder(int count, boolean expectedValue) {
        MatchInfo matchInfo = MatchInfo.of(5, true);

        assertThat(matchInfo.isCountUnder(count)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isCountUnder() {
        return Stream.of(
                Arguments.of(5, false),
                Arguments.of(10, true)
        );
    }
}
