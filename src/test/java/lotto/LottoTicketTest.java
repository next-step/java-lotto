package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("일치 번호 갯수 확인")
    public void get_matching_score() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        long matchingScore = lottoTicket.getMatchingScore(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(matchingScore).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 번호 일치 여부 확인")
    public void get_match_bonus() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        boolean matchBonus = lottoTicket.getMatchBonus(6);
        assertThat(matchBonus).isTrue();
    }
}
