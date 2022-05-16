package lotto.domain.constant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RankTest {

    @ParameterizedTest
    @MethodSource("일치갯수와_상금이_일치한지_매개변수")
    void 일치갯수와_상금이_일치한지_확인(int correspondCount, int prizeMoney) {
        assertThat(Rank.create(correspondCount).getPrizeMoney()).isEqualTo(prizeMoney);
    }

    static Stream<Arguments> 일치갯수와_상금이_일치한지_매개변수() {
        return Stream.of(
                arguments(3, 5000),
                arguments(4, 50000),
                arguments(5, 1500000),
                arguments(6, 2000000000),
                arguments(0, 0)
        );
    }


}
