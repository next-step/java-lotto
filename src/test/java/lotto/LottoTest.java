package lotto;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoFixture.*;


public class LottoTest {

    @Test
    void testConstructor() {
        Lotto lotto = new Lotto();

        Assertions.assertThat(lotto.numbers())
                .hasSize(Lotto.LOTTO_NUMBER)
                .allMatch(number -> number >= Lotto.START && number <= Lotto.END)
                .doesNotHaveDuplicates()
                .isSorted();
    }

    @Test
    void testNumbers() {
        Lotto lotto = new Lotto();

        Assertions.assertThat(lotto.numbers())
                .hasSize(Lotto.LOTTO_NUMBER)
                .allMatch(number -> number >= Lotto.START && number <= Lotto.END)
                .doesNotHaveDuplicates()
                .isSorted();
    }

    @DisplayName("로또 숫자가 같다면 두 로또 객체는 같다")
    @Test
    void testEquals() {
        String lottoList = "1,2,3,4,5,6";
        Lotto one = Lotto.of(lottoList);
        Lotto another = Lotto.of(lottoList);

        Assertions.assertThat(one)
                .isEqualTo(another);
    }

    @ParameterizedTest
    @MethodSource("providerTestMatchedCount")
    void testMatchedCount(Lotto lotto, Lotto winningLastWeek, int matched) {
        Assertions.assertThat(lotto.matchedCount(winningLastWeek))
                .isEqualTo(matched);
    }

    static Stream<Arguments> providerTestMatchedCount() {
        return Stream.of(
                Arguments.of(WINNING_NUMBER, NONE_MATCHED, 0),
                Arguments.of(WINNING_NUMBER, ONE_MATCHED, 1),
                Arguments.of(WINNING_NUMBER, THREE_MATCHED, 3),
                Arguments.of(WINNING_NUMBER, ALL_MATCHED, 6)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"})
    void testOf(String lottoStrings) {
        Lotto lotto = Lotto.of(lottoStrings);
        Assertions.assertThat(lotto.numbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"1,2,3", "0,0,0,0,0,0", "1,2,3,4,5,-6", "1,1,1,1,1,1"})
    void testOf_fail(String invalidLottoStrings){
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(invalidLottoStrings));
    }
}
