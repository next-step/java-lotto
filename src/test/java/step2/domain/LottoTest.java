package step2.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또")
public class LottoTest {

    @DisplayName("당첨번호 찾기")
    @Test
    public void findWinningNumbers() {
        Lotto lotto = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(new int[] { 1, 2, 3, 4, 5 ,6 });
        assertThat(lotto.findWinningNumbers(winningNumbers)).hasSize(6);
        assertThat(lotto.findWinningNumbers(winningNumbers)).contains(1, 2, 3, 4, 5, 6);
    }

}
