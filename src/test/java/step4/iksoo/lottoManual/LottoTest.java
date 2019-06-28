package step4.iksoo.lottoManual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(3, 8, 17, 26, 34, 42));
    }

    @Test
    void 로또_2등() {
        Lotto WINNER_NUMBERS = new Lotto(Arrays.asList(3, 8, 19, 26, 34, 42));
        assertThat(lotto.checkNumberOfMatches(WINNER_NUMBERS, new LottoNo(17))).isEqualTo(Rank.SECOND);
    }

    @Test
    void 로또_숫자_중복_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(3, 8, 17, 26, 34, 17));
        });
    }
}