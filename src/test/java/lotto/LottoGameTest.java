package lotto;

import lotto.model.LottoTicket;
import lotto.model.WinningInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private LottoGame lottoGame;
    private LottoTicket lottoTicket;
    private WinningInfo winningInfo;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
        lottoTicket = new LottoTicket(List.of(1, 5, 10, 11, 14, 16));
        winningInfo = new WinningInfo("3,5, 9, 11, 13, 20", 10);
    }

    @Test
    void getLottoCount() {
        assertThat(lottoGame.getLottoCount(15000)).isEqualTo(15);
    }

    @Test
    void getMatchCount() {
        assertThat(lottoGame.getMatchCount(winningInfo, lottoTicket)).isEqualTo(2);
    }

    @Test
    void containsBonusBall() {
        assertThat(lottoGame.containsBonusBall(winningInfo, lottoTicket)).isTrue();
    }
}