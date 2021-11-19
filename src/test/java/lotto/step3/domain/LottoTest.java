package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("입력된 당첨번호 6자리, 1~45, 중복값 x,  만족 못하면 -> IllegalArgumentException")
    void checkNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,5,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
        //정상입력
        assertThatCode(() -> new Lotto(Arrays.asList(1,2,3,4,5,6)))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("provideWiningNumbers")
    @DisplayName("당첨번호와 비교했을 때, 예상된 매칭수랑 맞는지 확인")
    void isMatchExpected(Lotto provided, int expected) {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 11, 12);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.isCountOfMatch(provided, expected)).isTrue();
    }

    private static Stream<Arguments> provideWiningNumbers() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 35, 37, 26)), 3),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 37, 26)), 4),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 26)), 5),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWiningNumbers1")
    @DisplayName("당첨번호와 비교했을 때, 5개 매칭 그리고 보너스 볼과 맞는지 확인(2등이냐?)")
    void isSecondPrizeWinner(Lotto provided, int bonusBall, boolean expected) {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 11, 12);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.isSecondPrizeWinner(provided, bonusBall)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWiningNumbers1() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 35, 37, 26)), 11, false),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 37, 26)), 11, false),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 26)), 11, true),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)), 11, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWiningNumbers2")
    @DisplayName("당첨번호와 비교했을 때, 매칭된 우승상금이랑 맞는가?")
    void prizeMoney(Lotto provided, int bonusBall, int money) {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 11, 12);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.calculatePrizeMoney(provided, bonusBall)).isEqualTo(money);
    }

    private static Stream<Arguments> provideWiningNumbers2() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 35, 37, 26)), 11, Rank.FIFTH.getPrizeMoney()),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 37, 26)), 11, Rank.FOURTH.getPrizeMoney()),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 26)), 5, Rank.THIRD.getPrizeMoney()),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 26)), 11, Rank.SECOND.getPrizeMoney()),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)), 11,Rank.FIRST.getPrizeMoney())
        );
    }

}