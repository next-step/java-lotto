package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoWinner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoWinnerTest {
    private String INPUT_SAMPLE_NUMBERS = "1, 2, 3, 4, 5, 6";
    private int INPUT_SAMPLE_BONUS_NUMBER = 7;

    private LottoWinner winner;

    @BeforeEach
    void setUp() {
        winner = new LottoWinner(LottoTicket.of(INPUT_SAMPLE_NUMBERS), INPUT_SAMPLE_BONUS_NUMBER);
    }

    @Test
    void correctWith() {
        LottoTicket compared = LottoTicket.of(INPUT_SAMPLE_NUMBERS);
        assertThat(winner.correctWith(compared)).isEqualTo(6);
    }

    @Test
    void hasBonus() {
        LottoTicket compared = LottoTicket.of(INPUT_SAMPLE_NUMBERS);
        assertThat(winner.hasBonus(compared)).isTrue();
    }
}
