package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinningStatisticTest {

    @DisplayName("생성자(금주의 당첨 번호)")
    @Test
    public void test_WinningStatistic_Constructor() {
        Lotto winningNumbers = Lotto.of(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(WinningStatistic.of(winningNumbers))
                .isEqualTo(WinningStatistic.of(winningNumbers));

    }

//    - 사용자의 로또 번호들과 금주의 당첨번호를 비교해주는 기능
//    - 수익률을 계산해 주는 기능
}
