package lotto.domain;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoTicketTest {

    @Test
    void 로또_티켓은_6개의_숫자를_가져야한다() {

        // when
        LottoTicket lottoTicket = LottoTicket.create();

        //then
        assertThat(lottoTicket.getTicketSize()).isEqualTo(6);
    }

    @Test
    void 당첨번호_개수를_구한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(numbers);
        List<Integer> rewardingNumbers = List.of(1, 6, 3, 8, 2, 19);
        int bonusNumber = 7;

        //when
        LottoRank actual = lottoTicket.getHitCount(rewardingNumbers, bonusNumber);

        //then
        assertThat(actual).isEqualTo(LottoRank.FOUR_HIT);
    }

    @Test
    void 보너스_당첨번호를_구한다() {
        //given
        boolean expected = true;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(numbers);

        //when
        boolean actual = lottoTicket.hasBonusNumber(3);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
