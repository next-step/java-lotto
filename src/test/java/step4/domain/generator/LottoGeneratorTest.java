package step4.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Lotto;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("String을 받아서 로또를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void createTest(String lottoString) {
        LottoGenerator lottoGenerator = new StringLottoGenerator(lottoString);
        Lotto lotto = lottoGenerator.generate();

        assertThat(lotto).isEqualTo(Lotto.of("1,2,3,4,5,6"));
    }

}
