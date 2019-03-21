package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMarketTest {
    @Test
    public void 로또구입() {
        List<Lotto> lottos = new ArrayList<>();
        LottoMarket.createLottos(lottos, 10);
        assertThat(lottos).hasSize(10);
    }
}