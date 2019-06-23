package step2.iksoo.lottoAuto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private final int LOTTO_SIZE = 6;
    private final List<Integer> LOTTO_NUMBERS = Arrays.asList(new Integer[]{3, 8, 17, 26, 34, 42});
    private final List<Integer> WINNER_NUMBERS = Arrays.asList(new Integer[]{3, 8, 19, 22, 34, 42});

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(LOTTO_NUMBERS);
    }

    @Test
    void 로또_구입완료() {
        assertThat(lotto.isNumSize(LOTTO_SIZE)).isTrue();
    }

    @Test
    void 로또맞은_개수_4개() {
        assertThat(lotto.checkNumberOfMatches(WINNER_NUMBERS)).isEqualTo(4);
    }
}
