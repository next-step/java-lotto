package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 당첨 결과 클래스 테스트")
class LottoResultTest {

    @Test
    @DisplayName("맞춘 번호가 3개인 로또결과가 1개인지 확인하는 테스트")
    void countLottoNumberWinning() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        int sameNumberCount = 3;

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addLottoNumber(1);
        lottoTicket.addLottoNumber(2);
        lottoTicket.addLottoNumber(3);
        lottoTicket.addLottoNumber(9);
        lottoTicket.addLottoNumber(30);
        lottoTicket.addLottoNumber(33);
        LottoTicket lottoTicket2 = new LottoTicket();
        lottoTicket.addLottoNumber(10);
        lottoTicket.addLottoNumber(12);
        lottoTicket.addLottoNumber(13);
        lottoTicket.addLottoNumber(19);
        lottoTicket.addLottoNumber(30);
        lottoTicket.addLottoNumber(33);

        lottoTicketList.add(lottoTicket);
        lottoTicketList.add(lottoTicket2);

        LottoResult result = new LottoResult(lottoTicketList, winningNumbers);
        Map<Integer, Integer> statistics = result.getStatistics().getStatistics();

        assertThat(statistics.get(sameNumberCount)).isEqualTo(1);
    }
}