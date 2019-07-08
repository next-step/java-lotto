package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoGameTest {
    List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 11, 12)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 10, 11, 13)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 10, 11, 13)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 9, 10, 11, 13)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 19, 20, 21, 22)));
    }

    @Test
    void result() {
        LottoGame lottoGame = new LottoGame(new Money(10000), money -> lottos);
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,10,11,13"), LottoNumber.of(8));
        LottoResult result = lottoGame.result(winningLotto);

        assertThat(result.getValue(Rank.FIRST)).isEqualTo(2);
        assertThat(result.getValue(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getValue(Rank.THIRD)).isEqualTo(0);
        assertThat(result.getValue(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.getValue(Rank.MISS)).isEqualTo(1);
    }
}