package step3.iksoo.lotto2rd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoesTest {
    private Lottoes customLottoes = new Lottoes(0);

    @BeforeEach
    public void setUp() {
        customLottoes.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        customLottoes.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        customLottoes.add(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)));
    }

    @Test
    public void 로또결과_1등_한명_당첨() {
        List<Integer> WINNER_NUMBERS = Arrays.asList(4, 5, 6, 7, 8, 9);
        int bonusBall = 5;
        assertThat(customLottoes.checkLotteryWin(WINNER_NUMBERS, bonusBall).get(Rank.FIRST)).isEqualTo(1);
    }
}