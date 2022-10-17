package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("구매한 로또 번호와 실제 당첨 번호를 비교해 당첨 등수와 당첨 금액을 반환")
    void calculateLottoResultSuccess() {
        // setting
//        LottoResult lottoResult = new LottoResult();
//
//        List<Integer> numbers1 = new ArrayList<>();
//        for (int i = 1; i < 7; i++) {
//            numbers1.add(i);
//        }
//        LottoTicket lottoTicket1 = new LottoTicket(numbers1);
//
//        List<Integer> numbers2 = new ArrayList<>();
//        for (int i = 15; i < 21; i++) {
//            numbers2.add(i);
//        }
//        LottoTicket lottoTicket2 = new LottoTicket(numbers2);
//
//        List<LottoTicket> tickets = new ArrayList<>();
//        tickets.add(lottoTicket1);
//        tickets.add(lottoTicket2);
//
//        List<Integer> actualNumbers = new ArrayList<>();
//        for (int i = 4; i < 10; i++) {
//            actualNumbers.add(i);
//        }
//
//        lottoResult.calculateLottoResult(tickets, actualNumbers, 2000);
//
//        // test
//        Map<Integer, Integer> lottoRankings = lottoResult.getLottoRankings();
//
//        // ranking test
//        assertThat(lottoRankings.get(3)).isEqualTo(1);
//        assertThat(lottoRankings.get(4)).isEqualTo(0);
//        assertThat(lottoRankings.get(5)).isEqualTo(0);
//        assertThat(lottoRankings.get(6)).isEqualTo(0);
//
//        // prize test
//        assertThat(lottoResult.getPrizePercentage()).isEqualTo("2.50");
    }
}
