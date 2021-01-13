package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnerLottoTicketTest {


    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5:1", "2, 4, 6, 7:2", "3, 4, 5:1", "1,2:3", "1:3"}, delimiter = ':')
    void winner_lotto_ticket_validation(String wrongInput, String bonusNumber) throws Exception {
        //When
        //Then
        Assertions.assertThatThrownBy(() -> {
            WinnerLottoTicket winnerLottoTicket = new WinnerLottoTicket(wrongInput, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:12:6", "1, 2, 3, 4, 5, 7:12:5", "1, 2, 3, 4, 8, 7:12:4"
        , "1, 2, 3, 9, 8, 7:12:3"}, delimiter = ':')
    void winner_match_ticket(String input, String bonusNumber, int result) throws Exception {
        //Given
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6));
        //When
        WinnerLottoTicket winnerLottoTicket = new WinnerLottoTicket(input, bonusNumber);
        LottoTicket lottoTicket = new LottoTicket(lottoNumberList);
        //Then
        Assertions.assertThat(result).isEqualTo(winnerLottoTicket.checkResult(lottoTicket));
    }


}
