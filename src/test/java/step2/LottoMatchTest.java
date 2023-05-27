package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoMatchTest {

    @Test
    void winnerMap에_없는_값으로_enum객체_찾기() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    LottoMatch.valueOf(2, true);
                }).withMessageMatching("Nothing Match");
    }

    @ParameterizedTest(name = "{0},{1} partner is {2}")
    @MethodSource("parameter")
    void matchCount와_bonusBall에_맞는_enum객체_찾기(int matchCount, boolean isBonusMatch, String enumName) {
        assertThat(LottoMatch.valueOf(matchCount, isBonusMatch).name()).isEqualTo(enumName);
    }

    static Stream<Arguments> parameter(){
        return Stream.of(
                arguments(5, true, LottoMatch.SECOND.name())
                ,arguments(5, false, LottoMatch.THIRD.name())
                ,arguments(6, false, LottoMatch.FIRST.name())
                ,arguments(3, false, LottoMatch.FIFTH.name())
        );
    }
}