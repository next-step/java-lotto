package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    @Test
    void 로또리스트는_로또결과리스트를_만든다() {
        LottoList lottoList = new LottoList(
                List.of(
                        Lotto.of(1, 2, 3, 4, 5, 6),
                        Lotto.of(1, 2, 3, 4, 5, 7)
                )
        );
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), new LottoNum(7));

        assertThat(lottoList.getResult(winningLotto)).containsExactly(Rank.FIRST, Rank.SECOND);
    }
}
