package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void 로또복권을_생성한다() {
        //Given
        LottoTicket lottoTicket = new LottoTicket();
        //When
        //Then
        assertThat(lottoTicket).isNotNull();
    }

    @Test
    void 로또번호_1부터_45까지를_생성하여_리스트에_담고_섞는다() {
        //Given
        LottoTicket lottoTicket = new LottoTicket();

        //When
        List<Integer> lottoBalls = lottoTicket.generateLottoBalls();

        //Then
        assertThat(lottoBalls.size()).isEqualTo(45);
    }

    @Test
    void 로또번호가_담긴_리스트로부터_6개의_숫자를_추출하여_리스트에_담는다() {
        //Given
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> lottoBalls = lottoTicket.generateLottoBalls();

        //When
        List<Integer> lotto = lottoTicket.pickSixBalls(lottoBalls);

        //Then
        assertThat(lotto.size()).isEqualTo(6);
    }
}
