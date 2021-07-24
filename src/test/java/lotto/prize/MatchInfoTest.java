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
}
