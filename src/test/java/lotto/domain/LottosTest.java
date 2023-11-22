package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class LottosTest {

    @Test
    @DisplayName("로또 개수로 생성한다.")
    void testLottosCreationWithCount() {
        // given
        int lottoCount = 5;

        // when
        Lottos lottos = new Lottos(lottoCount);

        // then
        assertThat(lottos.getValue()).hasSize(lottoCount);
    }

    @Test
    @DisplayName("로또들을 반환할 수 있다.")
    void testFindLottos() {
        // given
        Lottos lottos = new Lottos(List.of(
                "1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12")
        );

        // when
        String lottosString = lottos.findLottos();

        // then
        assertThat(lottosString).contains("[1, 2, 3, 4, 5, 6]", "[7, 8, 9, 10, 11, 12]");
    }
}
