package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class LottosTest {

    private LottoShop lottoShop = LottoShop.getInstance();

    @Test
    void 로또들을_저장할_수_있다() {
        // given
        final List<Lotto> lottos = lottoShop.buyAutoLottos(3);
        // when
        final Lottos allLotto = new Lottos(lottos);

        // then
        assertThat(allLotto.getLottos().size()).isEqualTo(3);
    }

    @Test
    void 모든_로또의_순위를_판단할_수_있다() {
        final List<Lotto> lottos = new ArrayList<>();

        final List<LottoNumber> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        final List<LottoNumber> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 7).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        lottos.add(new Lotto(lottoNumbers1));
        lottos.add(new Lotto(lottoNumbers2));

        final WinningLotto winningLotto = new WinningLotto(new Lotto(lottoNumbers1), new LottoNumber(8));

        final Lottos allLottos = new Lottos(lottos);

        final List<Ranking> rankings = allLottos.judgeAllUserLotto(winningLotto);

        assertAll(
            () -> assertThat(rankings).contains(Ranking.FIRST),
            () -> assertThat(rankings).contains(Ranking.THIRD)
        );
    }
}
