package lottoTest;

import lotto.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("입력한 갯수만큼 랜덤한 숫자를 가진 로또들을 발행한다.")
    void GENERATE_LOTTOS_BY_INPUT_COUNT() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        Assertions.assertThat(generator.generate(3).numberOfLotto())
            .isEqualTo(3);
    }
}
