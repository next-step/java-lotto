package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {
    @DisplayName("일치개수 확인")
    @Test
    public void PrizeTest() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(3,6,12,15,33,45));
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList(3,6,12,15,20,45));

        int matchCount = lottoPaper.checkPrize(winningNumbers);

        assertThat(matchCount).isEqualTo(5);
    }

}
