package lotto.model.domain;

import lotto.model.domain.Lotto;
import lotto.model.domain.LottoNumber;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {

    @Test
    void 로또_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또_객체_생성시_번호_주입() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // when & then
        assertThat(lotto.getNumbers())
                .isEqualTo(Stream.of(1, 2, 3, 4, 5, 6)
                        .map(LottoNumber::of)
                        .collect(Collectors.toUnmodifiableList()));
    }

    @Test
    void 로또_객체_생성시_번호_개수_6개_미만이면_실패() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @Test
    void 로또_객체_생성시_번호_개수_6개_초과면_실패() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }


    @ParameterizedTest
    @MethodSource("로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_테스트케이스")
    void 로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_성공(Lotto lotto, Rank expectedRank) {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        Rank rank = lotto.checkRank(winningNumbers);

        // then
        assertThat(rank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> 로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_테스트케이스() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(8, 9, 10, 11, 12, 13)), Rank.NONE)
        );
    }
}
