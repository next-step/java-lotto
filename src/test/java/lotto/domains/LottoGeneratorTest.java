package lotto.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.exceptions.LottoNumberFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = LottoGenerator.INSTANCE;

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
    void testSuccessPurchasedByManual() {
        assertThatNoException().isThrownBy(() -> lottoGenerator.purchaseByManual("1,2,3,4,5,6"));
    }

    @Test
    void testFailParseLottoString() {
        assertThatThrownBy(() -> lottoGenerator.createLotto("1,2,3,a,4,5"))
                .isInstanceOf(LottoNumberFormatException.class);
    }
}
