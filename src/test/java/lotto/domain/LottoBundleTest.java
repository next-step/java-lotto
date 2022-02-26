package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {

    private static final int size = 14;

    @DisplayName("구입한_금액에_맞춰_로또_개수를_생성하는지_테스트")
    @Test
    void findlottosSizeTest() {
        List<Lotto> lottos = LottoGenerator.lottoBundle(new ArrayList<>(), size);
        assertThat(lottos.size()).isEqualTo(size);
    }
}
