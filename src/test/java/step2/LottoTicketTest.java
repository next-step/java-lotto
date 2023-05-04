package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    private LottoTicket lottoTicket;
    private List<Integer> officialWinningNumbers;

    @BeforeEach
    public void init() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        lottoTicket = new LottoTicket(numbers);
    }

    @Test
    public void 로또티켓_탈락_체크_태스트() {
        officialWinningNumbers = new ArrayList<>();
        for (int i = 6; i < 12; i++) {
            officialWinningNumbers.add(i);
        }
        lottoTicket.checkWinningTicket(officialWinningNumbers);

        assertThat(lottoTicket.getSameNumberCount()).isEqualTo(0);
        assertThat(lottoTicket.getPrizeResult()).isEqualTo(0);

    }

    @Test
    public void 로또티켓_당첨_개수_상금_체크_태스트() {
        officialWinningNumbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            officialWinningNumbers.add(i);
        }
        lottoTicket.checkWinningTicket(officialWinningNumbers);

        assertThat(lottoTicket.getSameNumberCount()).isEqualTo(LottoPrizeEnum.LOTTO_PRIZE_FIRST.getSameNumberCnt());
        assertThat(lottoTicket.getPrizeResult()).isEqualTo(LottoPrizeEnum.LOTTO_PRIZE_FIRST.getPrize());

    }

}
