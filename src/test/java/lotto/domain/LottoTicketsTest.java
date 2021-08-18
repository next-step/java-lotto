package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @Test
    public void LottoTickets가_2개_주어졌을_때_합칠_수_있다(){
        //given
        LottoTickets lottoTickets1 = new LottoTickets(
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
        );

        LottoTickets lottoTickets2 = new LottoTickets(
                Arrays.asList(
                        new LottoTicket(
                                new ArrayList<>(Arrays.asList(new LottoNumber(13), new LottoNumber(14),
                                        new LottoNumber(15), new LottoNumber(16), new LottoNumber(17),
                                        new LottoNumber(18)))),
                        new LottoTicket(
                                new ArrayList<>(Arrays.asList(new LottoNumber(19), new LottoNumber(20),
                                        new LottoNumber(21), new LottoNumber(22), new LottoNumber(23),
                                        new LottoNumber(24))))
                )
        );
        //when
        LottoTickets mergedLottoTickets = lottoTickets1.mergeWith(lottoTickets2);
        //then
        assertThat(mergedLottoTickets).isEqualTo(
                new LottoTickets(
                        Arrays.asList(
                                new LottoTicket(
                                        new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                                                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                                                new LottoNumber(6)))),
                                new LottoTicket(
                                        new ArrayList<>(Arrays.asList(new LottoNumber(7), new LottoNumber(8),
                                                new LottoNumber(9), new LottoNumber(10), new LottoNumber(11),
                                                new LottoNumber(12)))),
                                new LottoTicket(
                                        new ArrayList<>(Arrays.asList(new LottoNumber(13), new LottoNumber(14),
                                                new LottoNumber(15), new LottoNumber(16), new LottoNumber(17),
                                                new LottoNumber(18)))),
                                new LottoTicket(
                                        new ArrayList<>(Arrays.asList(new LottoNumber(19), new LottoNumber(20),
                                                new LottoNumber(21), new LottoNumber(22), new LottoNumber(23),
                                                new LottoNumber(24))))
                        )
                )
        );
    }
}