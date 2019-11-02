package lotto.domain;

import org.junit.jupiter.api.Test;

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
        text = text.substring(1, text.length()-1);
        String[] tokens = text.split(",");

        int notNumberCount = (int)Arrays.stream(tokens)
                .map(token -> Integer.parseInt(token.trim()))
                .filter(token -> token<1 || token >45).count();

        assertThat(tokens.length).isEqualTo(6);
        assertThat(notNumberCount).isEqualTo(0);
    }

    @Test
    void 로또티켓_클래스생성_수동숫자_유효성체크(){
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket("1,2,3,4,5,6,7");
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket("1,2,3,*,5,6");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 일치갯수_확인(){
        LottoTicket winNumbers = new LottoTicket("1,2,3,4,5,6");
        assertThat(new LottoTicket("1,2,3,4,5,6").countCompareWinNumbers(winNumbers)).isEqualTo(6);
        assertThat(new LottoTicket("1,2,3,14,15,16").countCompareWinNumbers(winNumbers)).isEqualTo(3);
        assertThat(new LottoTicket("11,12,13,14,15,16").countCompareWinNumbers(winNumbers)).isEqualTo(0);
    }

}
