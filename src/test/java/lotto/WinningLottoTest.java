package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningLottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void 전역변수_셋팅() {
        LottoTicket ticket = LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = new LottoNumber(7);
        winningLotto = new WinningLotto(ticket, bonus);
    }

    @Test
    void 로또티켓과_중복없는_보너스번호() {
        LottoTicket ticket = LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = new LottoNumber(7);
        assertThat(new WinningLotto(ticket, bonus)).isEqualTo(new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    void 로또티켓에_이미_포함된_숫자가_보너스번호인_경우_에러() {
        LottoTicket ticket = LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = new LottoNumber(6);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLotto(ticket, bonus));
    }

    @Test
    void 당첨된_로또_확인_없을때() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.createFromIntegerList(List.of(10, 11, 12, 13, 14, 15)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(winningLotto.prizes(tickets)).isEmpty();
    }

    @Test
    void 당첨된_로또_확인_5등_1장() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 13, 14, 15)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(winningLotto.prizes(tickets)).containsExactly(LottoPrize.FIFTH);
    }

    @Test
    void 당첨된_로또_확인_4등_1장() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 14, 15)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(winningLotto.prizes(tickets)).containsExactly(LottoPrize.FORTH);
    }

    @Test
    void 당첨된_로또_확인_3등_1장() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 10)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(winningLotto.prizes(tickets)).containsExactly(LottoPrize.THIRD);
    }

    @Test
    void 당첨된_로또_확인_2등_1장() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 7)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(winningLotto.prizes(tickets)).containsExactly(LottoPrize.SECOND);
    }


    @Test
    void 당첨된_로또_확인_1등_1장() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(winningLotto.prizes(tickets)).containsExactly(LottoPrize.FIRST);
    }

    @Test
    void 당첨된_로또_확인_여러장_당첨_5등_1개_4등_1개_3등_1개_2등_1개_1등_2개() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 13, 14, 15)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 14, 15)),
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 15)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 7)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6)),
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25)),
                LottoTicket.createFromIntegerList(List.of(20, 21, 22, 23, 24, 25))
        );

        assertThat(winningLotto.prizes(tickets)).isEqualTo(
                List.of(LottoPrize.FIFTH, LottoPrize.FORTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST, LottoPrize.FIRST))
        ;
    }
}
