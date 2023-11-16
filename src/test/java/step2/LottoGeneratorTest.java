package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @ParameterizedTest
    @CsvSource(value = {"500:0", "1000:1", "2500:2"}, delimiter = ':')
    public void 금액에_맞게_생성된_로또_개수_확인_테스트(int money, int expectedSize) {
        assertThat(lottoGenerator.generateLottos(money)).hasSize(expectedSize);
    }
}
