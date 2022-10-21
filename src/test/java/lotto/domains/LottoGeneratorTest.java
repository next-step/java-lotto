package lotto.domains;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @ParameterizedTest
    @CsvSource(value = {
            "1000, 1",
            "1500, 1"
    })
    void Given_Money_When_GenerateLotto_Then_SizeIsCorrect(String money, int expectedSize) {
        List<Lotto> generate = lottoGenerator.purchaseByAuto(new LottoPurchasedAmount(money));

        assertThat(generate.size()).isEqualTo(expectedSize);
    }
}
