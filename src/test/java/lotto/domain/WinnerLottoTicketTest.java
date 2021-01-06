package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinnerLottoTicketTest {

    @Test
    void winner_lotto_ticket_validation() throws Exception {
        //Given
        String wrongInput = "1,  2, 3, 4, 5";
        //When
        //Then
        Assertions.assertThatThrownBy(() -> {
            WinnerLottoTicket winnerLottoTicket = new WinnerLottoTicket(wrongInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winner_match_ticket() throws Exception {
        //Given
        String input = "1,2,3,4,5,6";
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6));
        //When
        WinnerLottoTicket winnerLottoTicket = new WinnerLottoTicket(input);
        LottoTicket lottoTicket = new LottoTicket(lottoNumberList);
        //Then
        Assertions.assertThat(6).isEqualTo(winnerLottoTicket.checkResult(lottoTicket));
    }

}
