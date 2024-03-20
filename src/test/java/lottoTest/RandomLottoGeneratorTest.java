package lottoTest;

import lotto.RandomLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottoGeneratorTest {

    @Test
    @DisplayName("입력한 갯수만큼 랜덤한 숫자를 가진 로또들을 발행한다.")
    void GENERATE_LOTTOS_BY_INPUT_COUNT() {
        RandomLottoGenerator generator = new RandomLottoGenerator();
        Assertions.assertThat(generator.generate(3).numberOfLotto())
            .isEqualTo(3);
    }
}
