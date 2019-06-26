package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(3,53,2,7,1,4));

        this.lottos = new Lottos(Arrays.asList(lotto1, lotto2));
    }

    @Test
    @DisplayName("로또의 개수")
    void getCount() {
        assertThat(lottos.getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또를 사는데 사용한 금액")
    void getBuyingMoney() {
        assertThat(lottos.getBuyingMoney()).isEqualTo(2000);
    }

    @Test
    @DisplayName("로또 matching 개수와 bonus number에 따른 Prize 리턴")
    void matches() {
        final Lotto lottoWithWinningNumbers = new Lotto(Arrays.asList(1,2,3,4,5,22));
        final int bonusNumber = 5;
        final WinningLotto winningLotto = new WinningLotto(lottoWithWinningNumbers, bonusNumber);
        List<Prize> prizes = lottos.matches(winningLotto);

        assertThat(prizes.size()).isEqualTo(2);
        assertThat(prizes).contains(Prize.SECOND, Prize.FOURTH);
    }
}
