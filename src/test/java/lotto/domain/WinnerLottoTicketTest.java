package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinnerLottoTicketTest {

    @ParameterizedTest
    @CsvSource(value = {
            "'1,2,3,4,5,6','1,2,3,8,9,10',7,5등"
            , "'1,2,3,4,5,6','1,2,3,5,8,9',7,4등"
            , "'1,2,3,4,5,6','1,2,3,4,5,9',7,3등"
            , "'1,2,3,4,5,6','1,2,3,4,5,9',6,2등"
            , "'1,2,3,4,5,6','1,2,3,4,5,6',7,1등"
    })
    void winningLottoTest(String buyLottoNumbers, String winningLottoNumber, int bounsNumber, String rank) {

        LottoTicket lottoTicket = new LottoTicket(buyLottoNumbers);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket(winningLottoNumber), bounsNumber);

        LottoRank lottoRank = winningLottoTicket.getWinnerLotto(lottoTicket);

        assertThat(lottoRank.rank).isEqualTo(rank);
    }

    @Test
    void vaildBounsNumber() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), 6);

                }).withMessageContaining("보너스 번호 중복");

    }
}
