package lotto.domain;

import lotto.fixture.LottoNumberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketsTest {

    @DisplayName("주어진 티켓과 당첨번호를 통해 추첨결과를 계산할 수 있다.")
    @Test
    void calculate() {
        // given
        WinningLottoNumbers winnings = WinningLottoNumbers.of(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        LottoNumbers first = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers second = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 5, 7)));
        LottoNumbers third = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 4, 5, 8)));
        LottoNumbers fourth = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 6, 8, 9)));
        LottoNumbers fifth = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoNumbers none = LottoNumbers.from(LottoNumberFixture.로또_번호_생성(Arrays.asList(1, 2, 7, 8, 9, 10)));

        LottoTickets tickets = LottoTickets.of(Arrays.asList(first, second, third, fourth, fifth, none));

        // when
        LotteryResult result = tickets.calculate(winnings);

        // then
        assertAll(
                () -> assertThat(result.getStatistics()).containsKey(Rank.FIRST),
                () -> assertThat(result.getStatistics()).containsKey(Rank.SECOND),
                () -> assertThat(result.getStatistics()).containsKey(Rank.THIRD),
                () -> assertThat(result.getStatistics()).containsKey(Rank.FOURTH),
                () -> assertThat(result.getStatistics()).containsKey(Rank.FIFTH),
                () -> assertThat(result.getStatistics()).containsKey(Rank.NONE),
                () -> assertThat(result.getStatistics().get(Rank.FIRST)).isEqualTo(1L),
                () -> assertThat(result.getStatistics().get(Rank.SECOND)).isEqualTo(1L),
                () -> assertThat(result.getStatistics().get(Rank.THIRD)).isEqualTo(1L),
                () -> assertThat(result.getStatistics().get(Rank.FOURTH)).isEqualTo(1L),
                () -> assertThat(result.getStatistics().get(Rank.FIFTH)).isEqualTo(1L),
                () -> assertThat(result.getStatistics().get(Rank.NONE)).isEqualTo(1L)
        );
    }
}
