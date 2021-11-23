package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    private final LottoShop shop = new LottoShop();

    @ParameterizedTest
    @CsvSource(value = {"0,0", "500,0", "1000,1"})
    void buy(String moneyString, int lottoCount) {
        List<Lotto> lottos = shop.buy(moneyString);
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }

}
