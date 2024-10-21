package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    void 로또_구매_테스트() {
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(14000, 3);
        List<Lotto> manualNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            manualNumbers.add(getLottoNumbers());
        }
        Lottos lottos = new Lottos(manualNumbers, lottoPurchaseInfo.calculateAutoCount());
        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }

    private static Lotto getLottoNumbers() {
        return Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
    }
}