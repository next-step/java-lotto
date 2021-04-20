package step4.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.lotto.domain.Rank;
import step4.lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private List<Integer> winningLottoNumber ;
    private int bonusNumber;
    @BeforeEach
    void setUp(){
        winningLottoNumber = Arrays.asList(1,2,3,4,5,6);
        bonusNumber = 7;
    }

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6), bonusNumber );
        assertThat(winningLotto).isEqualTo(new WinningLotto(Arrays.asList(1,2,3,4,5,6), bonusNumber ));
    }

    @Test
    void 로또_2등_확인(){
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, bonusNumber );
        List<Integer> secondLottoNumber = Arrays.asList(1,2,3,4,5,7);

        assertThat(winningLotto.match(secondLottoNumber)).isEqualTo(Rank.SECOND);
    }
}
