package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 당첨 테스트")
class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        LottoTicket lottoTicket = new LottoTicket(Set.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)));
        winningLotto = new WinningLotto(lottoTicket);
    }

    @DisplayName("승리 로또와 일치하는 번호의 카운트를 확인할수 있다")
    @Test
    void winningLotto_create_success() {
        String winningNumbersString = "1,2,3,4,5,6";
        WinningLotto winningLotto = WinningLottoFactory.create(winningNumbersString);

        LottoTicket lottoTicket = new LottoTicket(new TreeSet<>(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(7)
        )));

        int countOfMatch = winningLotto.countOfMatch(lottoTicket);

        Assertions.assertThat(countOfMatch).isEqualTo(5);
    }

    @Test
    @DisplayName("6개의 숫자가 일치할 때 1등이다.")
    void shouldMatchFirstRankWhenAllNumbersMatch() {
        LottoTicket ticket = new LottoTicket(Set.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)));

        WinningRank rank = winningLotto.match(ticket);

        assertEquals(WinningRank.FIRST, rank);
    }

    @Test
    @DisplayName("5개의 숫자가 일치할 때 2등이다.")
    void shouldMatchSecondRankWhenFiveNumbersMatch() {
        LottoTicket ticket = new LottoTicket(Set.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(7)));

        WinningRank rank = winningLotto.match(ticket);

        assertEquals(WinningRank.SECOND, rank);
    }

    @Test
    @DisplayName("4개의 숫자가 일치할 때 3등이다.")
    void shouldMatchThirdRankWhenFourNumbersMatch() {
        LottoTicket ticket = new LottoTicket(Set.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(10), new LottoNumber(11)));

        WinningRank rank = winningLotto.match(ticket);

        assertEquals(WinningRank.THIRD, rank);
    }

    @Test
    @DisplayName("3개의 숫자가 일치할 때 3등이다.")
    void shouldMatchFourthRankWhenThreeNumbersMatch() {
        LottoTicket ticket = new LottoTicket(Set.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(11),
                new LottoNumber(12), new LottoNumber(13)));

        WinningRank rank = winningLotto.match(ticket);

        assertEquals(WinningRank.FOURTH, rank);
    }

    @Test
    @DisplayName("2개의 숫자가 일치할 때 0등이다.")
    void shouldMatchNoneRankWhenTwoNumbersMatch() {
        LottoTicket ticket = new LottoTicket(Set.of(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(13), new LottoNumber(14),
                new LottoNumber(15), new LottoNumber(16)));

        WinningRank rank = winningLotto.match(ticket);

        assertEquals(WinningRank.NONE, rank);
    }

    @Test
    @DisplayName("1개의 숫자가 일치할 때 0등이다.")
    void shouldMatchNoneRankWhenOneNumbersMatch() {
        LottoTicket ticket = new LottoTicket(Set.of(
                new LottoNumber(1), new LottoNumber(12),
                new LottoNumber(13), new LottoNumber(14),
                new LottoNumber(15), new LottoNumber(16)));

        WinningRank rank = winningLotto.match(ticket);

        assertEquals(WinningRank.NONE, rank);
    }

    @DisplayName("0개의 숫자가 일치할 때 0등이다.")
    @Test
    void shouldMatchNoneRankWhenNothingNumbersMatch() {
        LottoTicket ticket = new LottoTicket(Set.of(
                new LottoNumber(11), new LottoNumber(12),
                new LottoNumber(13), new LottoNumber(14),
                new LottoNumber(15), new LottoNumber(16)));

        WinningRank rank = winningLotto.match(ticket);

        assertEquals(WinningRank.NONE, rank);
    }
}
