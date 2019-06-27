package step3.iksoo.lotto2rd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(3, 8, 17, 26, 34, 42));
    }

    @Test
    void 로또_구입완료() {
        assertThat(lotto.getLotto().size()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test
    void 로또_2등() {
        List<Integer> WINNER_NUMBERS = Arrays.asList(3, 8, 19, 26, 34, 42);
        assertThat(lotto.checkNumberOfMatches(WINNER_NUMBERS, 17)).isEqualTo(Rank.SECOND);
    }
}