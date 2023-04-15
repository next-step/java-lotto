package lotto.model;

import lotto.LottoTicketMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void getMatchCount() {
        List<Integer> winningLottosA = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottosB = List.of(11, 22, 33, 12, 0, -1);
        assertThat(lottoTicket.getMatchCount(winningLottosA)).isEqualTo(6);
        assertThat(lottoTicket.getMatchCount(winningLottosB)).isEqualTo(0);
    }

    @Test
    void containsBonusBall() {
        int bonusNumberA = 15;
        int bonusNumberB = 6;
        assertThat(lottoTicket.containsBonusBall(bonusNumberA)).isFalse();
        assertThat(lottoTicket.containsBonusBall(bonusNumberB)).isTrue();
    }
}