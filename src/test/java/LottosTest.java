import domain.Lotto;
import domain.Lottos;
import domain.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {


    @Test
    void 구입_금액_1000원_단위로_로또_개수가_생성된다() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.size()).isEqualTo(14);
    }


    @Test
    void 금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lottos(800))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 전체_로또의_당첨_번호_일치_개수_목록을_반환한다() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(40, 41, 42, 43, 44, 45))
        ));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottos.checkResult(winningNumber)).containsExactly(6, 3, 0);
    }
}