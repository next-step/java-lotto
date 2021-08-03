package lottos.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {

    @DisplayName("로또 발급 로직")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "10000:10"}, delimiter = ':')
    void 로또발급_1장당_1000원(final int price, final int result) {
        Shop shop = new Shop(new LottoRandomGenerator(), 1000);
        List<Lotto> lottos = shop.issue(price);
        assertEquals(lottos.size(), result);
    }
}
