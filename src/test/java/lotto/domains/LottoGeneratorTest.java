package lotto.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.exceptions.NotEnoughPurchasedAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @ParameterizedTest
    @CsvSource(value = {
            "1000, 1",
            "1500, 1"
    })
    void Given_Money_When_GenerateLotto_Then_SizeIsCorrect(String money, int expectedSize) {
        List<Lotto> generate = lottoGenerator.purchaseByAuto(LottoPurchasedAmount.of(money));

        assertThat(generate.size()).isEqualTo(expectedSize);
    }

    @Test
    void Given_NotEnoughMoney_When_PurchaseByManual_Then_Fail() {
        LottoPurchasedAmount amount = LottoPurchasedAmount.of("1000");
        List<String> purchasedByManualList = List.of(
                "1,2,3,4,5,6",
                "11,12,13,14,15,16"
        );

        assertThatThrownBy(
                () -> lottoGenerator.purchaseByManual(amount, purchasedByManualList)
        ).isInstanceOf(NotEnoughPurchasedAmountException.class);
    }

    @Test
    void testSuccessPurchasedByManual() {
        LottoPurchasedAmount amount = LottoPurchasedAmount.of("1000");
        List<String> purchasedByManualList = List.of("1,2,3,4,5,6");

        assertThatNoException().isThrownBy(
                () -> lottoGenerator.purchaseByManual(amount, purchasedByManualList)
        );
    }
}
