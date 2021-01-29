package lotto.domain;

import lotto.dto.NumberData;
import lotto.dto.TicketData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {
    private LottoTicket ticket;

    @BeforeEach
    void setUp() {
        ticket = new LottoTicket(
            new ArrayList<LottoNumber>() {{
                add(new LottoNumber(1));
                add(new LottoNumber(2));
                add(new LottoNumber(3));
                add(new LottoNumber(4));
                add(new LottoNumber(5));
                add(new LottoNumber(6));
            }}
        );
    }

    @DisplayName("티켓 내의 숫자가 6개가 아닌 경우 예외를 던지는지 확인")
    @Test
    void isNotProperNumberCnt() {
        assertThrows(RuntimeException.class, () -> {
            new LottoTicket(
                new ArrayList<LottoNumber>() {{
                    add(new LottoNumber(1));
                }}
            );
        });
    }

    @DisplayName("티켓 내의 숫자중 중복이 있을경우 예외를 던지는지 확인")
    @Test
    void haveDuplicateNumber() {
        assertThrows(RuntimeException.class, () -> {
            new LottoTicket(
                new ArrayList<LottoNumber>() {{
                    add(new LottoNumber(1));
                    add(new LottoNumber(2));
                    add(new LottoNumber(3));
                    add(new LottoNumber(4));
                    add(new LottoNumber(5));
                    add(new LottoNumber(5));
                }}
            );
        });
    }

    @DisplayName("두 티켓의 같은 숫자 개수를 잘 반환하는지 확인")
    @Test
    void countMatches() {
        LottoTicket otherTicket = new LottoTicket(
            new ArrayList<LottoNumber>() {{
                add(new LottoNumber(5));
                add(new LottoNumber(6));
                add(new LottoNumber(7));
                add(new LottoNumber(8));
                add(new LottoNumber(9));
                add(new LottoNumber(10));
            }}
        );

        assertThat(otherTicket.getMatchedCnt(ticket)).isEqualTo(2);
        assertThat(ticket.getMatchedCnt(otherTicket)).isEqualTo(2);
    }

    @DisplayName("특정 번호를 포함하고 있는지를 잘 체크하는지 확인")
    @Test
    void isIncludeNumber() {
        assertThat(
            ticket.includeNumber(
                new LottoNumber(1)
            )
        ).isEqualTo(true);
    }

    @DisplayName("특정 번호를 포함하고 있지 않은지를 잘 체크하는지 확인")
    @Test
    void isNotIncludeBounsNumber() {
        assertThat(
            ticket.includeNumber(
                new LottoNumber(1)
            )
        ).isEqualTo(true);
    }

    @DisplayName("티켓 데이터를 잘 생성하는지 확인")
    @Test
    void getTicketData() {
        assertThat(
            ticket.getTicketData()
        ).isEqualTo(
            new TicketData(
                new ArrayList<NumberData>() {{
                    add(new NumberData(1));
                    add(new NumberData(2));
                    add(new NumberData(3));
                    add(new NumberData(4));
                    add(new NumberData(5));
                    add(new NumberData(6));
                }}
            )
        );
    }
}
