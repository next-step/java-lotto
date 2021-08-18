package lotto.common;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketParserTest {

    @Test
    public void 문자열을_입력받았을_때_파싱을_통해_List로_변환할_수_있다() {
        //given
        LottoTicketParser parser = new LottoTicketParser();
        //when
        LottoTicket lottoTicket = parser.parse("1, 2, 3, 4, 5, 6");
        //then
        assertThat(lottoTicket).isEqualTo(
                new LottoTicket(
                        new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                                new LottoNumber(6)))));
    }
}
