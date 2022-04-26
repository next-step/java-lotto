package lotto.domain;

import static lotto.domain.LottoTicket.ONE_TICKET_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void lottoNumberCountTest() {
        LottoTicket ticket = LottoTicket.create();

        assertThat(ticket.countLottoNumber()).isEqualTo(ONE_TICKET_LOTTO_NUMBER);
    }

    @DisplayName("일등 당첨된 로또 테스트 결과를 확인한다.")
    @Test
    void checkLotteryTest1() {
        List<Integer> winLottoNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket ticket = LottoTicket.create(1,2,3,4,5,6);

        LottoResult lottoResult = ticket.checkLottery(winLottoNumbers);

        assertThat(lottoResult.fitCount()).isEqualTo(6);
        assertThat(lottoResult.reward()).isEqualTo(Grade.FIRST.getReward());
    }

    @DisplayName("이등 당첨된 로또 테스트 결과를 확인한다.")
    @Test
    void checkLotteryTest2() {
        List<Integer> winLottoNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket ticket = LottoTicket.create(1,2,3,4,5,7);

        LottoResult lottoResult = ticket.checkLottery(winLottoNumbers);

        assertThat(lottoResult.fitCount()).isEqualTo(5);
        assertThat(lottoResult.reward()).isEqualTo(Grade.SECOND.getReward());
    }

    @DisplayName("삼등 당첨된 로또 테스트 결과를 확인한다.")
    @Test
    void checkLotteryTest3() {
        List<Integer> winLottoNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket ticket = LottoTicket.create(1,2,3,4,7,8);

        LottoResult lottoResult = ticket.checkLottery(winLottoNumbers);

        assertThat(lottoResult.fitCount()).isEqualTo(4);
        assertThat(lottoResult.reward()).isEqualTo(Grade.THIRD.getReward());
    }

    @DisplayName("tk등 당첨된 로또 테스트 결과를 확인한다.")
    @Test
    void checkLotteryTest4() {
        List<Integer> winLottoNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket ticket = LottoTicket.create(1,2,3,7,8,9);

        LottoResult lottoResult = ticket.checkLottery(winLottoNumbers);

        assertThat(lottoResult.fitCount()).isEqualTo(3);
        assertThat(lottoResult.reward()).isEqualTo(Grade.FOURTH.getReward());
    }

    @DisplayName("맞는게 적어서 당첨되지 않은 로또 테스트 결과를 확인한다.")
    @Test
    void checkLotteryTest5() {
        List<Integer> winLottoNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket ticket = LottoTicket.create(1,2,7,8,9,10);

        LottoResult lottoResult = ticket.checkLottery(winLottoNumbers);

        assertThat(lottoResult.fitCount()).isEqualTo(0);
        assertThat(lottoResult.reward()).isEqualTo(Grade.NONE.getReward());
    }

    @DisplayName("아예 당첨되지 않은 로또 테스트 결과를 확인한다.")
    @Test
    void checkLotteryTest6() {
        List<Integer> winLottoNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoTicket ticket = LottoTicket.create(11,12,13,14,15,16);

        LottoResult lottoResult = ticket.checkLottery(winLottoNumbers);

        assertThat(lottoResult.fitCount()).isEqualTo(0);
        assertThat(lottoResult.reward()).isEqualTo(Grade.NONE.getReward());
    }

    @Test
    void createTest() {
        LottoTicket lottoTicket = LottoTicket.create();
        LottoTicket lottoTicket1 = LottoTicket.create();

        assertThat(lottoTicket).isNotEqualTo(lottoTicket1);
    }
}