package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints={3,4,5,6})
    void 로또_생성_개수_확인(int input) {
        assertThat(LottoGenerator.publish(input).size()).isEqualTo(input);
    }

}