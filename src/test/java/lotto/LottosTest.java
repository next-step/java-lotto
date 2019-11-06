package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoProvider;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private static final int LOTTO_COUNT = 5;
    private Lottos lottos;
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = LottoProvider.create(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> rawLottos = new ArrayList<>();
        rawLottos.add(winningLotto);
        rawLottos.add(LottoProvider.create(Arrays.asList(1, 2, 3, 4, 5, 8), 7));
        rawLottos.add(LottoProvider.create(Arrays.asList(1, 2, 3, 4, 5, 8), 10));
        rawLottos.add(LottoProvider.create(Arrays.asList(1, 2, 3, 4, 9, 8), 7));
        rawLottos.add(LottoProvider.create(Arrays.asList(1, 2, 3, 10, 9, 8), 7));
        rawLottos.add(LottoProvider.create(Arrays.asList(1, 2, 11, 10, 9, 8), 7));
        rawLottos.add(LottoProvider.create(Arrays.asList(1, 2, 11, 10, 9, 8), 7));
        lottos = new Lottos(rawLottos);
    }

    @ParameterizedTest
    @EnumSource(LottoRank.class)
    void compareTest(LottoRank lottoRank) {
        assertThat(lottos.compareTo(winningLotto).getValue().keySet()).contains(lottoRank);
    }
}
