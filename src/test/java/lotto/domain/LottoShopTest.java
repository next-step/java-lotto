package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {


    @ParameterizedTest
    @CsvSource(value = {"5000:3", "3000:1", "12000:6"}, delimiter = ':')
    public void purchaseTicketTest(int purchasePrice, int manualLottoQuantity) {
        //Given
        LottoShop shop = new LottoShop(new LottoAutoMachine());

        //When
        LottoTicket ticket = shop.purchaseTicket(Money.from(purchasePrice), manualLottoQuantity);

        //Then
        assertThat(ticket).isEqualTo(LottoTicket.of(purchasePrice / LottoShop.LOTTO_PRICE, manualLottoQuantity));
    }

    @ParameterizedTest
    @MethodSource("createMenualLottos")
    public void purchaseLottosTest(List<Lotto> manualLottos) {
        //Given
        int totalQuantity = 10;
        LottoShop shop = new LottoShop(new LottoAutoMachine());

        //When
        Lottos lottos = shop.purchaseLottos(LottoTicket.of(totalQuantity, manualLottos.size()), manualLottos);

        //Then
        assertThat(lottos.quantity()).isEqualTo(totalQuantity);
    }

    private static Stream<Arguments> createMenualLottos() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        Lotto.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        Lotto.of(new HashSet<>(Arrays.asList(1, 3, 5, 30, 23, 6))),
                        Lotto.of(new HashSet<>(Arrays.asList(1, 3, 5, 30, 15, 40)))
                )
        );
    }
}