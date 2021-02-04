package lotto.domain;

import lotto.wrapper.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @DisplayName("두 티켓의 같은 값이 몇개 있는지를 잘 반환하는지")
    @Test
    void countMatches() {
        LottoTicket ticket1 = new LottoTicket(
                new ArrayList<LottoNumber>() {{
                    add(new LottoNumber(1));
                    add(new LottoNumber(2));
                    add(new LottoNumber(3));
                    add(new LottoNumber(4));
                    add(new LottoNumber(5));
                    add(new LottoNumber(6));
                }}
        );

        LottoTicket ticket2 = new LottoTicket(
                new ArrayList<LottoNumber>() {{
                    add(new LottoNumber(5));
                    add(new LottoNumber(6));
                    add(new LottoNumber(7));
                    add(new LottoNumber(8));
                    add(new LottoNumber(9));
                    add(new LottoNumber(10));
                }}
        );

        assertThat(
                ticket1.countMatches(ticket2)
        ).isEqualTo(2);
    }

    @DisplayName("특정 번호를 포함하고 있는지를 잘 체크하는지 확인")
    @Test
    void isIncludeNumber() {
        LottoTicket ticket = new LottoTicket(
                new ArrayList<LottoNumber>() {{
                    add(new LottoNumber(1));
                    add(new LottoNumber(2));
                    add(new LottoNumber(3));
                    add(new LottoNumber(4));
                    add(new LottoNumber(5));
                    add(new LottoNumber(6));
                }}
        );

        assertThat(
                ticket.includeNumber(
                        new LottoNumber(1)
                )
        ).isEqualTo(true);
    }

    @DisplayName("특정 번호를 포함하고 있지 않은지를 잘 체크하는지 확인")
    @Test
    void notIncludeBounsNumber() {
        LottoTicket ticket = new LottoTicket(
                new ArrayList<LottoNumber>() {{
                    add(new LottoNumber(1));
                    add(new LottoNumber(2));
                    add(new LottoNumber(3));
                    add(new LottoNumber(4));
                    add(new LottoNumber(5));
                    add(new LottoNumber(6));
                }}
        );

        assertThat(
                ticket.includeNumber(
                        new LottoNumber(1)
                )
        ).isEqualTo(true);
    }

    @DisplayName("문자열(수동로또)로 생성할 때 6자리 안 맞는 경우의 예외 발생.")
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "1, 2, 3, 4, 5, 6, 7"
    })
    void exceptConstructMatchSix(String input) {
        assertThatThrownBy(() -> new LottoTicket(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("문자열(수동로또)로 생성할 때 숫자,콤마,공백 이외를 포함하 때의 예외 발생.")
//    @ParameterizedTest
//    @CsvSource({
//            "1, 2, 3,+ 4, 5, - 6",
//            "1, 2,hello 3, 4, 5, world6, 7",
//            "1, 2, 3, 4, 5, 6"
//    })
    @Test
    void exceptConstructOtherFormats() {
        String ip = "1, 2, 3, 4, 5, ㅁ";
        assertThatThrownBy( () -> new LottoTicket(ip) )
                .isInstanceOf(NumberFormatException.class);

    }
}