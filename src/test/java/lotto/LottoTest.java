package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private static final LottoNumber one = new LottoNumber(1);
    private static final LottoNumber two = new LottoNumber(2);
    private static final LottoNumber three = new LottoNumber(3);
    private static final LottoNumber four = new LottoNumber(4);
    private static final LottoNumber five = new LottoNumber(5);
    private static final LottoNumber six = new LottoNumber(6);
    private static final LottoNumber seven = new LottoNumber(7);
    private static final LottoNumber eight = new LottoNumber(8);
    private static final LottoNumber nine = new LottoNumber(9);

    @ParameterizedTest
    @MethodSource(value = "provideLotto")
    void countMatch(Lotto lotto, int matchCount) {
        Lotto winLotto = new Lotto(Arrays.asList(one, two, three, four, five, six));

        assertThat(lotto.countMatch(winLotto)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> provideLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(Arrays.asList(one, two, three, four, five, six)), 6),
                Arguments.of(
                        new Lotto(Arrays.asList(one, two, three, four, five, seven)), 5),
                Arguments.of(
                        new Lotto(Arrays.asList(one, two, three, four, seven, eight)), 4),
                Arguments.of(
                        new Lotto(Arrays.asList(one, two, three, seven, eight, nine)), 3)
        );
    }

}