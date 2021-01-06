package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void lotto_ticket_generate_test() throws Exception {
        //Given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );
        //When
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        //Then
        Assertions.assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @Test
    void lotto_ticket_size_exception() throws Exception {
        //Given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5)
        );
        //When and Then
        Assertions.assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void lotto_ticket_duplicate_exception() throws Exception {
        //Given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(5),
            new LottoNumber(5),
            new LottoNumber(5)
        );
        //When and Then
        Assertions.assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
