package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoGameTest {
    List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottos.add(LottoAuto.of(Arrays.asList(1, 2, 3, 4, 11, 12)));
        lottos.add(LottoAuto.of(Arrays.asList(1, 2, 3, 10, 11, 13)));
        lottos.add(LottoAuto.of(Arrays.asList(1, 2, 3, 10, 11, 13)));
        lottos.add(LottoAuto.of(Arrays.asList(1, 2, 8, 10, 11, 13)));
        lottos.add(LottoAuto.of(Arrays.asList(1, 2, 19, 20, 21, 22)));
    }

    @Test
    void result() {
        LottoGame lottoGame = new LottoGame(() -> lottos)
                .addManual(Collections.emptyList());
        WinningLotto winningLotto = new WinningLotto(LottoManual.of("1,2,3,10,11,13"), LottoNumber.of(8));
        LottoResult result = lottoGame.result(winningLotto);

        assertThat(result.getValue(Rank.FIRST)).isEqualTo(2);
        assertThat(result.getValue(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getValue(Rank.THIRD)).isEqualTo(0);
        assertThat(result.getValue(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.getValue(Rank.MISS)).isEqualTo(1);
    }

    @Test
    void resultAddManual() {
        LottoGame lottoGame = new LottoGame(() -> lottos)
                .addManual(Collections.singletonList("1,2,3,10,5,6"));

        WinningLotto winningLotto = new WinningLotto(LottoManual.of("1,2,3,10,11,13"), LottoNumber.of(8));
        LottoResult result = lottoGame.result(winningLotto);

        assertThat(result.getValue(Rank.FIRST)).isEqualTo(2);
        assertThat(result.getValue(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getValue(Rank.THIRD)).isEqualTo(0);
        assertThat(result.getValue(Rank.FOURTH)).isEqualTo(2);
        assertThat(result.getValue(Rank.MISS)).isEqualTo(1);
    }

    @Test
    void autoCount() {
        LottoGame lottoGame = new LottoGame(() -> lottos);
        assertThat(lottoGame.getLottos().size()).isEqualTo(lottos.size());
    }

    @Test
    void manualCount() {
        LottoGame lottoGame = new LottoGame(Collections::emptyList)
                .addManual(List.of("1,2,3,4,5,6"));
        assertThat(lottoGame.getLottos().size()).isEqualTo(1);
    }

    @Test
    void autoAndManualCount() {
        LottoGame lottoGame = new LottoGame(() -> lottos)
                .addManual(List.of("1,2,3,4,5,6"));
        assertThat(lottoGame.getLottos().size()).isEqualTo(lottos.size() + 1);
    }
}