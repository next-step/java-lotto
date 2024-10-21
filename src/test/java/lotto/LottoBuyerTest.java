package lotto;

import lotto.service.LottoBuyer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoBuyerTest {

    private final LottoBuyer lottoBuyer = new LottoBuyer();

    @Test
    public void 구매가능한_로또개수() {
        assertThat(lottoBuyer.canBuyLottoCount(10000))
                .isEqualTo(10);
    }

    @Test
    public void 로또_구매() {
        assertThat(lottoBuyer.buyLotto(new ArrayList<>(List.of(1, 5, 20, 35, 41, 22))))
                .isEqualTo(List.of(1, 5, 20, 35, 41, 22));
    }
}
