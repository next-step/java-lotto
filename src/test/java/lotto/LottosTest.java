package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("주어진 개수만큼 로또를 생성한다")
    void shouldCreateLottos() {
        Lottos lottos = new Lottos(3);
        assertThat(lottos.values().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("조건을 만족하는 로또 개수를 센다")
    void shouldCheckWinningNumbers() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = create();

        long matchedThreeNumbers = lottos.result(winningNumbers, count -> count == 3);
        assertThat(matchedThreeNumbers).isEqualTo(2);
    }

    private Lottos create() {
        Lotto lotto1 = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 10, 11, 12)));
        Lotto lotto3 = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 13, 14, 15)));

        return new Lottos(Arrays.asList(lotto1, lotto2, lotto3));
    }
}