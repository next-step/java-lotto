import domain.Lotto;
import domain.Lottos;
import domain.Rank;
import domain.WinningLotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {


    @Test
    void 구입_금액만큼_로또가_생성된다() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.size()).isEqualTo(14);
    }


    @Test
    void 전체_로또의_등수_목록을_반환한다() {
        Lottos lottos = new Lottos(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,2,3,10,11,12"),
                new Lotto("40,41,42,43,44,45")
        );
        WinningLotto winningLotto = new WinningLotto(7, 1, 2, 3, 4, 5, 6);

        assertThat(lottos.checkResult(winningLotto)).containsExactly(Rank.FIRST, Rank.FIFTH, Rank.MISS);
    }
}