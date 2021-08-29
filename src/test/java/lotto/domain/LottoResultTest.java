package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("현재 산 로또들의 당첨갯수를 저장할 수 있다.")
    void saveLottoResultTest() {

        // given
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));

        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));
        lottos.add(lotto1);
        lottos.add(lotto2);
        Lottos buyLottos = new Lottos(lottos);

        // when
        LottoResult lottoResult = LottoResult.calculateLottoResult(buyLottos, winLotto);

        // then
        assertThat(lottoResult.first()).isEqualTo(1);
        assertThat(lottoResult.fourth()).isEqualTo(1);
    }
}