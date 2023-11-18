package lotto.domain.lotto.wrapper;

import lotto.domain.lotto.LotteryRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static lotto.domain.lotto.LotteryRank.*;
import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @DisplayName("6개의 Number객체를 컬렉션으로 가지는 Numbers객체를 생성한다.")
    @Test
    void creatNumbers() {
        // given
        Set<Integer> inputs = Set.of(1, 5, 12, 21, 32, 43);

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(inputs);

        // then
        assertThat(lottoNumbers.numbers()).hasSize(6)
            .containsExactly(1, 5, 12, 21, 32, 43);
    }

    @DisplayName("자신이 가지고 있는 로또 번호와 인자로 받은 당첨번호(+보너스)의 값이 몇 개 일치하는 지 확인하고 반환한다.")
    @ParameterizedTest
    @MethodSource("provideArguments")
    void countMatchingNumbersWithBonus(LottoNumbers lotto, int expectedResult) {
        // given
        LottoNumbers winningNumber = new LottoNumbers(Set.of(1, 5, 12, 21, 32, 43));

        // when
        int count = lotto.countMatchingNumbers(winningNumber);

        // then
        assertThat(count).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
          Arguments.of(new LottoNumbers(Set.of(1, 5, 12, 21, 32, 43)), FIRST.matchingCount()),
          Arguments.of(new LottoNumbers(Set.of(1, 5, 12, 21, 32, 42)), THIRD.matchingCount()),
          Arguments.of(new LottoNumbers(Set.of(1, 5, 12, 21, 31, 42)), FOURTH.matchingCount()),
          Arguments.of(new LottoNumbers(Set.of(1, 5, 12, 20, 31, 42)), FIFTH.matchingCount())
        );
    }
}
