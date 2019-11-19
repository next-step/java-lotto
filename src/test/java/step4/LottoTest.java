package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("구매한 로또 합치기")
    @Test
    public void 구매한_로또_합치기() {
        LottoGenerator.generateStandardLotto();
        int lotto1Size = 2;
        int lotto2Size = 3;
        Set<Lotto> lotto1 = LottoGenerator.purchasedLottos(lotto1Size);
        Set<Lotto> lotto2 = LottoGenerator.purchasedLottos(lotto2Size);
        Set<Lotto> totalLotto = Lotto.mergeLottoSets(lotto1, lotto2);

        assertThat(totalLotto.size()).isEqualTo(lotto1Size + lotto2Size);
    }
}
