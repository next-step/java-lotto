package lotto;

import org.junit.jupiter.api.Test;
import random.LottoGenerateStrategy;
import random.LottoGenerator;
import random.RandomLottoNumbers;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @Test
    public void 금액_개수_변환테스트() {
        int purchaseAmount = 14000;
        Lotto lotto = Lotto.InitLotto(purchaseAmount);
        assertThat(lotto).isEqualTo(new Lotto(new TryLottoCount(14)));
    }

}
