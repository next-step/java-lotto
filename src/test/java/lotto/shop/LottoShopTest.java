package lotto.shop;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.machine.TestLottoGenerator;
import lotto.domain.shop.LottoShop;
import lotto.domain.shop.Money;
import lotto.domain.shop.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoShopTest {
    @ParameterizedTest
    @CsvSource(value = {"1200:1", "3800:3", "8800:8", "0:0", "100:0", "16000:16"}, delimiter = ':')
    @DisplayName("구입 금액을 입력하면, 금액에 해당하는 만큼 로또를 발급한다.")
    void lottoPurchaseTest(long money, long lottoQuantity) {
        LottoShop lottoShop = new LottoShop(new Money(money), new TestLottoGenerator(0));

        LottoOrderedList lottoOrderedList = lottoShop.purchase();

        assertThat(lottoOrderedList.getLottoOrderedCount()).isEqualTo(lottoQuantity);
    }

    @Test
    @DisplayName("총 로또 4장을 구입하는데, 수동이 2장이다.")
    void manualLottoPurchaseTest() {
        List<Lotto> predefined = new ArrayList<>();
        predefined.add(new Lotto(1, 2, 3, 4, 5, 6));
        predefined.add(new Lotto(7, 8, 9, 10, 11, 12));
        Order order = new Order(new Money(4000), predefined);
        LottoShop lottoShop = new LottoShop(order, new TestLottoGenerator(0));

        LottoOrderedList lottoOrderedList = lottoShop.purchase();

        assertThat(lottoOrderedList.getLottoOrderedCount()).isEqualTo(4L);
    }
}
