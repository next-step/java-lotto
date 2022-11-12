package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoShopTest {

    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop();
    }

    @DisplayName("구입 금액에 해당하는 만큼 로또 구매")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "1500:1", "9999:9"}, delimiter = ':')
    void purchaseCountTest(int input, int expected) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(input);

        Lottos lottos = lottoShop.purchase(purchaseMoney, List.of());

        assertThat(lottos.getCount()).isEqualTo(expected);
    }

    @DisplayName("수동 로또 번호를 포함한 로또 구매")
    @Test
    void purchaseWithManualLottoNumbersTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(14000);
        List<LottoNumbers> manualLottoNumbers = List.of(
            LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6)),
            LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6)),
            LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6))
        );

        Lottos lottos = lottoShop.purchase(purchaseMoney, manualLottoNumbers);

        assertThat(lottos.getCount()).isEqualTo(14);
    }

    @DisplayName("수동 로또 수가 구입할 수 있는 로또 수보다 큰 경우 예외 발생")
    @Test
    void purchaseExcessLottosTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000);
        List<LottoNumbers> manualLottoNumbers = List.of(
            LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6)),
            LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6)),
            LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6))
        );

        assertThatThrownBy(() -> lottoShop.purchase(purchaseMoney, manualLottoNumbers))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동 로또 구매 개수가 구매 가능한 수보다 많습니다.");
    }
}
