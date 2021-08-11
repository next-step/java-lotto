package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 로또들이_주어졌을_때_동등성_확인을_할_수_있다(){
        //given
        LottoTicket lottoTicket = new LottoTicket(new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6))));
        //when
        //then
        assertThat(lottoTicket).isEqualTo(new LottoTicket(new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6)))));
    }
}
