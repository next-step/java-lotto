package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WiningLottoTicket;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LotteryResultsTest {
    private LotteryResults lotteryResults;
    //4등티켓 2개와 3등 1개  2등 1개
    private WiningLottoTicket winingLottoTicket;

    @Before
    public void setUp() throws Exception {

        winingLottoTicket = new WiningLottoTicket(LottoTicket.of(1, 2, 3, 4, 5, 6), LottoNumber.getBasicNumber(7));
        UserLottoTickets userLottoTickets = new UserLottoTickets();
        LottoTicket fourthTicket = LottoTicket.of(1, 2, 3, 4, 7, 8); //4등 4개 번호동일
        LottoTicket fourthTicket2 = LottoTicket.of(1, 2, 3, 5, 7, 8); //4등 4개 번호동일
        LottoTicket ThirdTicket = LottoTicket.of(1, 2, 3, 4, 5, 10);//3등   5개의번호 동일
        LottoTicket secondTicket = LottoTicket.of(1, 2, 3, 4, 5, 7);// 2등 5개의 번호동일 + 보너스넘버포함
        userLottoTickets.add(fourthTicket);
        userLottoTickets.add(fourthTicket2);
        userLottoTickets.add(secondTicket);
        userLottoTickets.add(ThirdTicket);
        lotteryResults = new LotteryResults(winingLottoTicket, userLottoTickets);
    }

    @Test
    public void 당첨_4등2개_3등1개_결과값에_플러스1() {
        assertThat(lotteryResults.getLottoResults().get(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(lotteryResults.getLottoResults().get(LottoRank.THIRD)).isEqualTo(1);
    }


}