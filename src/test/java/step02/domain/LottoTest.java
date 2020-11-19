package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step02.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {

    @DisplayName("생성자 테스트")
    @Test
    public void test_Lotto_Constructor() {
        List<LottoNumber> lotto = Mock.makeLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(Lotto.of(lotto)).isEqualTo(Lotto.of(lotto));
    }

    private static Stream<Arguments> provideWinningLottoResult() {
        return Stream.of(
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(8, 21, 23, 41, 42, 43))), 0),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(3, 5, 11, 16, 32, 38))), 2),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(7, 11, 16, 35, 36, 44))), 0),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(1, 8, 11, 31, 41, 42))), 1),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(13, 14, 16, 38, 42, 45))), 0),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(7, 11, 30, 40, 42, 43))), 0),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(2, 13, 22, 32, 38, 45))), 1),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(23, 25, 33, 36, 39, 41))), 0),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(1, 3, 5, 14, 22, 45))), 3),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(5, 9, 38, 41, 43, 44))), 1),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(2, 8, 9, 18, 19, 21))), 1),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(13, 14, 18, 21, 23, 35))), 0),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(17, 21, 29, 37, 42, 45))), 0),
                Arguments.of(Lotto.of(Mock.makeLotto(Arrays.asList(3, 8, 27, 30, 35, 44))), 1)
        );
    }

    @DisplayName("Lotto 와 winningLotto 를 비교")
    @ParameterizedTest
    @MethodSource("provideWinningLottoResult")
    public void test_compareWithWinner(Lotto lotto, int expect) {
        Lotto winningNumbers = Lotto.of(Mock.makeLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(expect);
    }

}
