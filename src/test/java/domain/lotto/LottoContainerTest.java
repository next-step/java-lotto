package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoContainerTest {

    @DisplayName("주어진 개수만큼 로또 발급")
    @Test
    void createLottoContainer() {
        // given
        int lottoCount = 5;

        // when
        LottoContainer lottoContainer = new LottoContainer(lottoCount);

        // then
         Assertions.assertThat(lottoContainer.size()).isEqualTo(lottoCount);
    }

    @DisplayName("로또 개수가 0개인 경우 IllegarArgumentException throw")
    @Test
    void createLottoContainerException() {
        // given
        int lottoCount = 0;

        // when
        Assertions.assertThatThrownBy(() -> new LottoContainer(lottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 개수는 1개 이상이어야 합니다.");
    }

    @DisplayName("1등 1개, 0등 1개")
    @Test
    void checkWinningResults() {
        // given
        int lottoCount = 5;
        LottoContainer lottoContainer = new LottoContainer(lottoCount);
    }
}
