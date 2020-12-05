package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    private static final int LOTTO_PRICE = 1_000;

    @ParameterizedTest
    @CsvSource(value = {"3000:2", "4000:2", "5000:1", "6000:5", "7000:5"}, delimiter = ':')
    public void exchangeAutoLottosTest(int purchasePrice, int manualLottoCount) {
        //Given
        int expectedAutoLottoCount = (purchasePrice / LOTTO_PRICE) - manualLottoCount;
        LottoShop shop = new LottoShop();

        //When
        Lottos autoLottos = shop.exchangeAutoLottos(new LottoTicket(expectedAutoLottoCount), new LottoAutoMachine());

        //Then
        assertThat(autoLottos).isNotNull();
        assertThat(autoLottos.quantity()).isEqualTo(expectedAutoLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 25, 3, 8, 10})
    public void exchangeManualLottosTest(int manualQuantity) {
        ///Given
        LottoShop shop = new LottoShop();

        //When
        Lottos manualLottos = new Lottos();
        for (int i = 0; i < manualQuantity; i++) {
            manualLottos = shop.exchangeManualLottos(new LottoTicket(manualQuantity), new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        }

        //Then
        assertThat(manualLottos.quantity()).isEqualTo(manualQuantity);
    }
}