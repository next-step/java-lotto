package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoNumbersTest.createLottoNumber;
import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @Test
    @DisplayName("from 호출 시 LottoNumbers 반환")
    void from() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 4, 5, 6));
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 4, 5, 6));
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = LottoTicket.from(lottoNumbersList);
        assertThat(lottoTicket.size()).isEqualTo(3);
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("computeLottoResult로 넘어오는 LottoNumber로 LottoResult 반환")
    void computeLottoResult() {

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 11, 22, 33));
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 21, 42, 45));
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 4, 44, 11));
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 4, 5, 11));

        LottoNumbers winningNumber = createLottoNumber(1, 2, 3, 4, 5, 6);

        LottoTicket lottoTicket = LottoTicket.from(lottoNumbersList);

        LottoResult lottoResult = lottoTicket.computeLottoResult(new WinningNumber(winningNumber, LottoNumber.valueOf(30)));
        assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("getLottoNumbers 호출 시 문자열로 치환된 모든 LottoNumber의 리스트를 반환")
    void getLottoNumbers() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 11, 22, 33));
        lottoNumbersList.add(createLottoNumber(1, 2, 3, 21, 42, 45));

        LottoTicket lottoTicket = LottoTicket.from(lottoNumbersList);
        assertThat(lottoTicket.getLottoTicketToString()).containsExactly("[1, 2, 3, 11, 22, 33]", "[1, 2, 3, 21, 42, 45]");
        assertThat(lottoTicket.getLottoTicketToString()).doesNotContain("[1, 2, 3, 4, 5, 6]");
    }
}
