package lotto;

import lotto.service.LottoGame;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasedLottosTest {
    private LottoGame lottoGame;

    @Before
    public void setUp() throws Exception {
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        lottoGame = LottoGame.getInstance(lottoGenerator);
    }

    @Test
    public void 금액14000원지불시_로또14개생성() {
        // given
        Money amount = new Money(14000);
        // when
        PurchasedLottos purchasedLottos = lottoGame.purchase(amount, new ArrayList<>());
        // then
        assertThat(purchasedLottos.getLottos().size()).isEqualTo(14);
    }

    @Test(expected = RuntimeException.class)
    public void 금액1000원미만지불시_예외발생() {
        // given
        Money amount = new Money(800);
        // when
        PurchasedLottos purchasedLottos = lottoGame.purchase(amount, new ArrayList<>());
        // then
    }

    @Test
    public void 금액2000원지불_로또2개수동생성() {
        // given
        Money amount = new Money(2000);
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6");
        // when
        PurchasedLottos purchasedLottos = lottoGame.purchase(amount, manualLottos);
        // then
        assertThat(purchasedLottos.getLottos())
                .allMatch(lotto1 -> lotto1.toString()
                        .equals("[1, 2, 3, 4, 5, 6]"));
    }
}
