package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketText {

    @Test
    void 로또티켓_클래스생성_수동숫자() {
        LottoTicket lottoTicket2 = new LottoTicket("1,2,3,4,5,6");
        assertThat(lottoTicket2.toString()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6).toString());
    }

    @Test
    void 로또티켓_클래스생성_자동숫자_유효성체크() {
        LottoTicket lottoTicket = new LottoTicket();

        String text = lottoTicket.toString();
        text = text.substring(1, text.length() - 1);
        String[] tokens = text.split(",");

        int notNumberCount = (int) Arrays.stream(tokens)
                .map(token -> Integer.parseInt(token.trim()))
                .filter(token -> token < 1 || token > 45)
                .count();

        assertThat(tokens.length).isEqualTo(6);
        assertThat(notNumberCount).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,*,5,6"})
    void 로또티켓_클래스생성_수동숫자_유효성체크(String text) {
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket(text);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,16:THIRD", "1,2,13,14,15,7:MISS"}, delimiter = ':')
    void 로또_등수_계산(String text, Rank rank) {
        LottoTicket winTicket = new LottoTicket("1,2,3,4,5,6");
        int bonusNumber = 7;
        LottoTicket ticket = new LottoTicket(text);
        assertThat(ticket.calculateRank(winTicket, bonusNumber)).isEqualTo(rank);
    }


}
