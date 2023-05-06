package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LotteResultCheckerTest {


    @Test
    void 결과확인() {
        LottoTicket t1 = LottoTicket.createLottoTicketByManual(new ArrayList<>(Arrays.asList(1, 10, 20, 25, 30, 45)));
        LottoTicket t2 = LottoTicket.createLottoTicketByManual(new ArrayList<>(Arrays.asList(2, 10, 20, 25, 30, 45)));
        LottoTicket t3 = LottoTicket.createLottoTicketByManual(new ArrayList<>(Arrays.asList(1, 11, 20, 25, 30, 45)));
        LottoTicket t4 = LottoTicket.createLottoTicketByManual(new ArrayList<>(Arrays.asList(1, 11, 21, 25, 30, 45)));
        LottoTicket t5 = LottoTicket.createLottoTicketByManual(new ArrayList<>(Arrays.asList(1, 10, 20, 26, 31, 45)));
        LottoTicket t6 = LottoTicket.createLottoTicketByManual(new ArrayList<>(Arrays.asList(1, 10, 20, 26, 31, 44)));
        LottoTicket t7 = LottoTicket.createLottoTicketByManual(new ArrayList<>(Arrays.asList(2, 11, 21, 26, 31, 44)));

        List<LottoTicket> lottoTickets = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7));
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 10, 20, 25, 30, 45));
        LottoResultChecker lottoResultChecker = new LottoResultChecker(lottoTickets, winningNumbers);

        Assertions.assertThat(lottoResultChecker.getRankCount(LottoRank.FIRST)).isEqualTo(1);
        Assertions.assertThat(lottoResultChecker.getRankCount(LottoRank.SECOND)).isEqualTo(2);
        Assertions.assertThat(lottoResultChecker.getRankCount(LottoRank.THIRD)).isEqualTo(2);
        Assertions.assertThat(lottoResultChecker.getRankCount(LottoRank.FOURTH)).isEqualTo(1);

        Assertions.assertThat(lottoResultChecker.getTotalPrizeMoney()).isEqualTo(2_003_105_000);
    }
}
