package lotto.domain;

import lotto.service.NumberSelectionStrategyImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("입력 개수만큼 다수의 로또 생성")
    void createLottos() {
        int lottoNum = 3;

        Lottos lottos = new Lottos(lottoNum, new NumberSelectionStrategyImpl());

        assertThat(lottos.getLottoList()).hasSize(lottoNum);
    }

    @Test
    @DisplayName("다수의 로또와 당첨 숫자 비교하여 결과 리스트 가져오기")
    void getRankMatchers() {
        Lotto lotto1 = new Lotto(size -> Numbers.builder().range(1, 7).build());
        Lotto lotto2 = new Lotto(size -> Numbers.builder().range(2, 7).add(10).build());
        Lotto lotto3 = new Lotto(size -> Numbers.builder().range(2, 8).build());
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3));
        WinningLotto winningLotto = new WinningLotto(Numbers.builder().range(1, 7).build(), new Number(10));

        List<RankMatcher> rankMatchers = lottos.getRankMatchers(winningLotto);

        assertThat(rankMatchers).containsExactly(
                new RankMatcher(6, false),
                new RankMatcher(5, true),
                new RankMatcher(5, false)
        );
    }
}
