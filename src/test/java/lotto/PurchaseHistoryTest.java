package lotto;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseHistoryTest {
    @Test
    public void 금액14000원지불시_로또14개생성() {
        // given
        int amount = 14000;
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        // when
        List<Lotto> lottos = new PurchaseHistory(amount, randomLottoGenerator).getLottos();
        // then
        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test(expected = RuntimeException.class)
    public void 금액1000원미만지불시_예외발생() {
        // given
        int amount = 800;
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        // when
        List<Lotto> lottos = new PurchaseHistory(amount, randomLottoGenerator).getLottos();
        // then
    }
}
