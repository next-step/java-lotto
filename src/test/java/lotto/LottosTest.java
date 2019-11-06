package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = LottoProvider.createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> rawLottos = new ArrayList<>();
        rawLottos.add(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        rawLottos.add(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        rawLottos.add(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        rawLottos.add(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 9, 8)));
        rawLottos.add(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 10, 9, 8)));
        rawLottos.add(LottoProvider.createLotto(Arrays.asList(1, 2, 11, 10, 9, 8)));
        rawLottos.add(LottoProvider.createLotto(Arrays.asList(1, 2, 11, 10, 9, 8)));
        lottos = new Lottos(rawLottos);
    }

    @ParameterizedTest
    @EnumSource(LottoRank.class)
    void compareTest(LottoRank lottoRank) {
        assertThat(lottos.compareTo(winningLotto).getValue().keySet()).contains(lottoRank);
    }
}
