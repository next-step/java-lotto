package lotto;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoFixture.*;


public class LottoTest {

    @Test
    void testConstructor() {
        Lotto lotto = new Lotto();

        Assertions.assertThat(lotto.numbers())
                .hasSize(Lotto.LOTTO_NUMBER)
                .allMatch(number -> number > Lotto.START && number <= Lotto.END)
                .doesNotHaveDuplicates()
                .isSorted();
    }

    @Test
    void testNumbers() {
        Lotto lotto = new Lotto();

        Assertions.assertThat(lotto.numbers())
                .hasSize(Lotto.LOTTO_NUMBER)
                .allMatch(number -> number > Lotto.START && number <= Lotto.END)
                .doesNotHaveDuplicates()
                .isSorted();
    }

    @DisplayName("로또 숫자가 같다면 두 로또 객체는 같다")
    @Test
    void testEquals() {
        List<Integer> lottoList = Lotto.creatNumbers();
        Lotto one = new Lotto(lottoList);
        Lotto another = new Lotto(lottoList);

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
}
