package lotto.shop;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.machine.TestLottoGenerator;
import lotto.domain.shop.LottoShop;
import lotto.domain.shop.Money;
import org.junit.jupiter.api.DisplayName;
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
}
