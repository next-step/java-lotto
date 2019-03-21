package lotto.domain.lotto;

import lotto.enums.Rank;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 임의의_로또_생성() {
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new WinningLotto(ticket, new LottoNumber(10));

        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 임의의_로또_정렬_후_생성() {
        Ticket ticket = new Ticket(1, 3, 5, 2, 4, 6);
        Lotto winningLotto = new WinningLotto(ticket, new LottoNumber(10));

        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또_숫자_매치_카운트_3개_일치() {
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        BasicLotto lotto = new BasicLotto(ticket);

        ticket = new Ticket(1, 2, 3, 7, 8, 9);
        WinningLotto winningLotto = new WinningLotto(ticket, new LottoNumber(10));

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 로또_숫자_매치_카운트_6개_일치() {
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        BasicLotto lotto = new BasicLotto(ticket);

        ticket = new Ticket(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(ticket, new LottoNumber(10));
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 보너스볼_포함_2등_여부_확인() {
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 10);
        BasicLotto lotto = new BasicLotto(ticket);

        ticket = new Ticket(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(ticket, new LottoNumber(10));
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.SECOND);
    }
}
