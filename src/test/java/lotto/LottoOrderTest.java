package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoOrderTest {

    @Test
    public void 금액14000원지불시_로또14개생성() {
        // given
        Money amount = new Money(14000);
        // when
        LottoOrder lottoOrder = new LottoOrder(amount, new ArrayList<>());
        // then
        assertThat(lottoOrder.getNumberOfAutoLottos()).isEqualTo(14);
    }

    @Test(expected = RuntimeException.class)
    public void 금액1000원미만지불시_예외발생() {
        // given
        Money amount = new Money(800);
        // when
        LottoOrder lottoOrder = new LottoOrder(amount, new ArrayList<>());
        // then
    }

    @Test
    public void 금액2000원지불_로또2개수동생성() {
        // given
        Money amount = new Money(2000);
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6");
        // when
        LottoOrder lottoOrder = new LottoOrder(amount, manualLottos);
        // then
        assertThat(lottoOrder.getNumberOfManualLottos()).isEqualTo(2);
    }

    @Test
    public void 금액3000원지불_로또2개수동생성_1개자동생성() {
        // given
        Money amount = new Money(3000);
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6");
        // when
        LottoOrder lottoOrder = new LottoOrder(amount, manualLottos);
        // then
        assertThat(lottoOrder.getNumberOfManualLottos()).isEqualTo(2);
        assertThat(lottoOrder.getNumberOfAutoLottos()).isEqualTo(1);
    }
}
