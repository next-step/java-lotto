package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    void 로또_구입() {
        assertThat(new LottoGame(14000).getTicketsString().size()).isEqualTo(14);
        assertThat(new LottoGame(1100).getTicketsString().size()).isEqualTo(1);
        assertThatThrownBy(() -> {
            new LottoGame(0);
        }).isInstanceOf(RuntimeException.class);
    }
    @Test
    void 당첨번호_확인() {
        List<LottoTicket> tickets = Arrays.asList(
                new LottoTicket("1,2,3,4,15,16"),
                new LottoTicket("1,2,3,14,15,16"),
                new LottoTicket("11,12,13,14,15,16")
        );
        LottoGame game = new LottoGame(tickets);
        List<String> results = game.getResultString("1,2,3,4,5,6");

        double takePercent = Math.round((double) 55000 / 3000 * 10000) / 100.0;
        String takePercentString = "총 수익률은 " + takePercent + "입니다.";

        assertThat(results.get(results.size()-1)).isEqualTo(takePercentString);
    }


}
