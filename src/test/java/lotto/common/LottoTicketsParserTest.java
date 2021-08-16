package lotto.common;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsParserTest {

    @Test
    public void 문자열을_입력받았을_때_파싱을_통해_List로_변환할_수_있다() {
        //given
        LottoTicketsParser parser = new LottoTicketsParser();
        //when
        LottoTickets lottoTickets = parser.parse(
                new ArrayList<>(Arrays.asList(
                        "1, 2, 3, 4, 5, 6",
                        "7, 8, 9, 10, 11, 12"))
        );
        //then

        assertThat(lottoTickets).isEqualTo(
                new LottoTickets(
                        Arrays.asList(
                                new LottoTicket(
                                        new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                                                new LottoNumber(6)))),
                                new LottoTicket(
                                        new ArrayList<>(Arrays.asList(new LottoNumber(7), new LottoNumber(8),
                                                new LottoNumber(9), new LottoNumber(10), new LottoNumber(11),
                                                new LottoNumber(12))))
                        )
                )
        );
    }
}
