package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

    @Test
    void 로또는_6_개의_숫자를_가진다() {
        Lotto lotto = new Lotto();
        lotto.makeNumbers();
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    void 로또는_6_개의숫자가_정렬된_상태이다(){
        Lotto lotto = new Lotto(List.of(9,8,2,1,3,10));
        Lotto result = new Lotto(List.of(1,2,3,8,9,10));
        assertEquals(lotto, result);
    }

    @Test
    void 로또가_일치하는_숫자가_있으면_그수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(1,9,8,7,11,12));
        assertEquals(1, lotto.countMatchingWinningLotto(winningLotto));
    }
}
