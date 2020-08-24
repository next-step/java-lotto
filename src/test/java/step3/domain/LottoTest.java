package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또")
public class LottoTest {

    WinningNumbers winningNumbers;

    @BeforeEach
    public void before() {
        winningNumbers = new WinningNumbers(new int[] { 1, 2, 3, 4, 5, 6 }, 7);
    }

    private Lotto createLotto(int ... nos) {
        return new Lotto(Arrays.stream(nos)
                .boxed()
                .map(LottoNo::new)
                .collect(Collectors.toList()));
    }

    @Test
    public void getRank_FIRST() {
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void getRank_SECOND() {
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 7);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void getRank_THIRD() {
        Lotto lotto = createLotto(1, 2, 3, 4, 5, 9);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void getRank_FOURTH() {
        Lotto lotto = createLotto(1, 2, 3, 4, 9, 10);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.FOURTH);
    }

}
