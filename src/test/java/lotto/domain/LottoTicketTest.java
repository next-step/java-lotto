package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 발급")
    public void createLottoTicket() throws Exception {
        //given
        LottoTicket lottoTicket = new LottoTicket();

        //when

        //then

    }

    @Test
    @DisplayName("로또 번호 6개인지 확인")
    public void checkLottoNumberSize() throws Exception {
        //given
        LottoTicket lottoTicket = new LottoTicket();

        //when
        List<Integer> numbers = lottoTicket.getTicketNumber();

        //then
        assertThat(numbers.size()).isEqualTo(6);
    }
}
