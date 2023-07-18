package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @Test
    void 당첨번호_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new WinningNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                LottoNumber.of(7)));
    }

    @Test
    void 당첨번호와_보너스볼이_중복되면_생성_실패() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(new Lotto(winningNumbers), LottoNumber.of(6)));
        assertThat(exception).hasMessage("당첨 번호와 보너스 볼은 중복될 수 없습니다.");
    }


    @ParameterizedTest
    @MethodSource("로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_성공_테스트케이스")
    void 로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_성공(Lotto lotto, Rank expectedRank) {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                LottoNumber.of(7));

        // when
        Rank rank = winningNumbers.checkRank(lotto);

        // then
        assertThat(rank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> 로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_성공_테스트케이스() {
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
