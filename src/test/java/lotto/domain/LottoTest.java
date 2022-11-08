package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @Test
    void duplicate_Lotto_Tickets() {
        Lotto lotto_one = new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        Lotto lotto_two = new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        assertThat(lotto_one.getNumberList()).isEqualTo(lotto_two.getNumberList());
    }

    @ParameterizedTest
    @MethodSource("provideNumberList")
    void compare_Lotto_Rank(List<LottoNumber> numberList, int count, boolean matchBonus) {
        List<Integer> winnerNumberList = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numberList);
        Lotto matchRank = lotto.matchRank(winnerNumberList, matchBonus);

        assertEquals(matchRank.getRank().getCount(), count);
    }

    private static Stream<? extends Arguments> provideNumberList() {
        return Stream.of(
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 6), 6, false),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 7), 5, false),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 7), 5, true),
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 7, 8), 4, false),
                Arguments.arguments(givenNumbers(1, 2, 3, 7, 8, 9), 3, false),
                Arguments.arguments(givenNumbers(1, 2, 7, 8, 9, 10), 2, false),
                Arguments.arguments(givenNumbers(1, 7, 8, 9, 10, 11), 1, false),
                Arguments.arguments(givenNumbers(7, 8, 9, 10, 11, 12), 0, false)
        );
    }

    private static List<LottoNumber> givenNumbers(int... numbers) {
        List<LottoNumber> result = Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList());

        return result;
    }


}
