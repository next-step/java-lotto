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
        Lotto lotto = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        Lotto nonMatched = new Lotto(Lists.newArrayList(11, 12, 13, 14, 15, 16));
        Lotto oneMatched = new Lotto(Lists.newArrayList(1, 12, 13, 14, 15, 16));
        Lotto threeMatched = new Lotto(Lists.newArrayList(1, 2, 3, 14, 15, 16));
        Lotto allMatched = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of(lotto, nonMatched, 0),
                Arguments.of(lotto, oneMatched, 1),
                Arguments.of(lotto, threeMatched, 3),
                Arguments.of(lotto, allMatched, 6)
        );
    }
}
