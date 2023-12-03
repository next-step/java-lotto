package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoWinGeneratorTest {

    static Stream<Arguments> namedArguments() {
        return Stream.of(
                arguments((Object) new Integer[]{1, 12, 13, 14, 15, 16}, "MISS")
                , arguments((Object) new Integer[]{1, 2, 13, 14, 15, 16}, "MISS")
                , arguments((Object) new Integer[]{1, 2, 3, 14, 15, 16}, "FOURTH")
                , arguments((Object) new Integer[]{1, 2, 3, 4, 15, 16}, "THIRD")
                , arguments((Object) new Integer[]{1, 2, 3, 4, 5, 16}, "SECOND")
                , arguments((Object) new Integer[]{1, 2, 3, 4, 5, 6}, "FIRST")
        );
    }

    @DisplayName("로또에 당첨된 수에 맞는 rank를 받는다.")
    @ParameterizedTest
    @MethodSource("namedArguments")
    void noCorrectNumber_getNoRank(Integer[] inputNumbers, String rank) {
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinGenerator generator = new LottoWinGenerator(winNumbers);
        Prize prize = generator.winPrize(Lotto.create(List.of(inputNumbers)));
        Assertions.assertThat(prize).isEqualTo(Prize.valueOf(rank));
    }

}
