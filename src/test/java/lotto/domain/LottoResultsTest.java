package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또결과 테스트")
public class LottoResultsTest {

    List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        lottoList = new ArrayList<>();
        lottoList.add(new Lotto(1, 2, 3, 4, 5, 6));
        lottoList.add(new Lotto(1, 2, 3, 4, 5, 7));
        lottoList.add(new Lotto(1, 2, 3, 4, 5, 10));
        lottoList.add(new Lotto(1, 2, 3, 4, 9, 10));
        lottoList.add(new Lotto(1, 2, 3, 8, 9, 10));
        lottoList.add(new Lotto(1, 2, 7, 8, 9, 10));
    }

    @Test
    @DisplayName("구매한 로또의 당첨 결과를 구하는 테스트")
    void match() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 7);

        Lottos lottos = new Lottos(lottoList);
        LottoResults lottoResults = lottos.findResult(winningLotto);
        Assertions.assertThat(lottoResults.findRankCount(Rank.FIRST)).isEqualTo(1);
    }

}
