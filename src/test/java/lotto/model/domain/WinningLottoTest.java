package lotto.model.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void 당첨번호_객체_생성_성공() {
        // given
        final Lotto winningNumbers = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber bonusBall = LottoNumber.of(7);

        // when & then
        assertThatNoException().isThrownBy(() -> WinningLotto.of(winningNumbers, bonusBall));
    }

    @Test
    void 당첨번호와_보너스볼이_중복되면_생성_실패() {
        // given
        final Lotto winningNumbers = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber bonusBall = LottoNumber.of(6);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(winningNumbers, bonusBall));
    }

    @ParameterizedTest
    @MethodSource("로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_테스트케이스")
    void 로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_성공(Lotto lotto, Rank expectedRank) {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final LottoNumber bonusBall = LottoNumber.of(7);
        final WinningLotto winningLotto = WinningLotto.of(Lotto.create(numbers), bonusBall);

        // when
        Rank rank = winningLotto.checkRank(lotto);

        // then
        assertThat(rank).isEqualTo(expectedRank);
    }


    static Stream<Arguments> 로또와_당첨번호_및_보너스볼을_비교해_Rank_반환_테스트케이스() {
        return Stream.of(
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 4, 8, 9)), Rank.FOURTH),
                Arguments.of(Lotto.create(List.of(1, 2, 3, 8, 9, 10)), Rank.FIFTH),
                Arguments.of(Lotto.create(List.of(8, 9, 10, 11, 12, 13)), Rank.NONE)
        );
    }
}
