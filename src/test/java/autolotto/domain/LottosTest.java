package autolotto.domain;

import autolotto.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest extends LottoNumbersFactory {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(from(Set.of(1, 2, 3, 4, 5, 6)));
        LottoNumbers lottoNumbers2 = new LottoNumbers(from(Set.of(1, 2, 3, 4, 5, 43)));
        lottos = new Lottos(List.of(lottoNumbers1, lottoNumbers2));
    }

    @Test
    void returnCost() {
        assertThat(lottos.cost()).isEqualTo(2000);
    }

    @Test
    void confirm() {
        lottos.confirm(new WinningLotto(new LottoNumbers(from(Set.of(1,2,3,4,5,6))), new LottoNumber(7)));
        assertThat(lottos.getResult().countOfWinners(Rank.FIRST)).isEqualTo(1);
        assertThat(lottos.getResult().countOfWinners(Rank.THIRD)).isEqualTo(1);
    }
}
