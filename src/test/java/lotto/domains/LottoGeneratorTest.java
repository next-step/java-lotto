package lotto.domains;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @ParameterizedTest
    @CsvSource(value = {
            "0, 0",
            "1000, 1",
            "1500, 1"
    })
    void Given_Money_When_GenerateLotto_Then_SizeIsCorrect(int money, int expectedSize) {
        List<Lotto> generate = lottoGenerator.purchaseByAuto(money);

        assertThat(generate.size()).isEqualTo(expectedSize);
    }

    @Test
    void testInputNegativeMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoGenerator.purchaseByAuto(-1));
    }
}
