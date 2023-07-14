package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    List<Lotto> dummy;

    @BeforeEach
    void setUp() {
        dummy = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(11, 12, 13, 14, 15, 16)),
            new Lotto(List.of(21, 22, 23, 24, 25, 26)),
            new Lotto(List.of(31, 32, 33, 34, 35, 36))
        );
    }

    @Test
    @DisplayName("Lottos를 정상적으로 생성한다.")
    void createSuccess() {
        /* given */

        /* when & then */
        assertDoesNotThrow(() -> new Lottos(dummy));
    }

    @Test
    @DisplayName("모든 로또의 결과를 구한다.")
    void checkAllLottoResult() {
        /* given */
        final Lottos target = new Lottos(dummy);
        final WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new LottoNumber(7));

        /* when */
        final List<Rank> result = target.checkAllLottoResult(winningLotto);

        /* then */
        assertThat(result).hasSize(4);
    }
}
