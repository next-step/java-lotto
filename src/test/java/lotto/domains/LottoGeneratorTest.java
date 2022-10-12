package lotto.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGeneratorTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0, 0",
            "1000, 1",
            "1500, 1"
    })
    void Given_Money_When_GenerateLotto_Then_SizeIsCorrect(int money, int expectedSize) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<Lotto> generate = lottoGenerator.generate(money);

        assertThat(generate.size()).isEqualTo(expectedSize);
    }
}
