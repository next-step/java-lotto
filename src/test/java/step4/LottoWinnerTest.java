package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinnerTest {

    @Test
    @DisplayName("당첨 로또 생성")
    public void test1() {
        Lotto userLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoWinner winningLotto = new LottoWinner(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        Rank rank = winningLotto.match(userLotto);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("보너스번호 중첩 테스트")
    public void test2() {
        assertThatThrownBy(() -> {
            new LottoWinner(Lotto.of(Arrays.asList(1,2,3,4,5,6)), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
