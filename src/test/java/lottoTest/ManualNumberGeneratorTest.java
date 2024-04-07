package lottoTest;

import lotto.Lotto;
import lotto.Lottos;
import lotto.ManualNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualNumberGeneratorTest {

    @Test
    @DisplayName("입력한 갯수만큼 사용자가 입력한 숫자를 가진 로또들을 발행한다.")
    void GENERATE_MANUAL_LOTTO_WITH_USER_INPUT() {
        Lottos lottos = Lottos.of(
            Lotto.of("1","2","3","4","5","6"),
            Lotto.of("7","8","9","10","11","12"),
            Lotto.of("13","14","15","16","17","18"));
        ManualNumberGenerator generator = new ManualNumberGenerator(lottos);

        Assertions.assertThat(generator.generate(3).numberOfLotto()).isEqualTo(3);
    }

}
