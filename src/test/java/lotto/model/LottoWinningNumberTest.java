package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningNumberTest {

    private static Stream<Arguments> prizeTestGenerator() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), LottoPrize.FIRST),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 7), LottoPrize.THIRD),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 40), LottoPrize.SECOND),
                Arguments.of(Set.of(10, 2, 3, 4, 5, 6), LottoPrize.THIRD),
                Arguments.of(Set.of(1, 2, 3, 4, 8, 9), LottoPrize.FOURTH),
                Arguments.of(Set.of(1, 20, 3, 10, 5, 12), LottoPrize.FIFTH),
                Arguments.of(Set.of(1, 2, 13, 14, 15, 16), LottoPrize.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("prizeTestGenerator")
    void 결과_판단(Set<Integer> numbers, LottoPrize expectedPrize) {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
                new Lotto(Set.of(1, 2, 3, 4, 5, 6)), new LottoNumber(40));
        Lotto myLotto = new Lotto(numbers);

        LottoPrize rank = lottoWinningNumber.getRank(myLotto);

        assertThat(rank).isEqualTo(expectedPrize);
    }


    @Test
    void 보너스_에러() {
        assertThatThrownBy(() -> {
            new LottoWinningNumber(
                    new Lotto(Set.of(1, 2, 3, 4, 5, 6)), new LottoNumber(6));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 넘버는 당첨 번호와 일치할 수 없습니다.");
    }


}
