package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("Lotto 번호 개수 46개 확인")
    void generate_lotto_numbers() throws Exception {
        //Given
        Lotto lotto = new Lotto();
        //When
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        //Then
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(46);
    }

    @Test
    @DisplayName("Lotto 용지 개수 6개 확인")
    void validate_lotto_ticket_number() throws Exception {
        //Given
        Lotto lotto = new Lotto();
        //When
        LottoTicket lottoNumbers = lotto.generateLottoTicket();
        //Then
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Lotto 구입하기")
    void buy_lotto_ticket() {
        //Given
        int money = 14_000;
        Lotto lotto = new Lotto();
        //When
        List<LottoTicket> lottoTickets = lotto.buyLottoTicket(money);
        //Then
        Assertions.assertThat(lottoTickets.size()).isEqualTo(14);
    }

}
