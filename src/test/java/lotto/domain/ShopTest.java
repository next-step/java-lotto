package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    private List<String> manualLottos = new ArrayList<>();

    @Test
    @DisplayName("로또 구매 test")
    void purchaseLottoTest() {
        manualLottos.add("1, 2, 3, 4 ,5, 6");
        List<Lotto> purchasedLottos = Shop.buyLottos(13000L, manualLottos);
        assertThat(purchasedLottos.size()).isEqualTo(13);
    }
}
