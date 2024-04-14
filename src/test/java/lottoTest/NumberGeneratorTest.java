package lottoTest;

import lotto.Lotto;
import lotto.LottoType;
import lotto.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    @Test
    @DisplayName("입력한 갯수만큼 사용자가 입력한 숫자를 가진 로또들을 발행한다.")
    void GENERATE_MANUAL_LOTTO_WITH_USER_INPUT() {
        Lotto lotto = Lotto.of(LottoType.MANUAL,"1", "2", "3", "4", "5", "6");

        Assertions.assertThat(
                NumberGenerator.generateManualNumbers(
                    new String[]{"1", "2", "3", "4", "5", "6"})).isEqualTo(lotto);
    }

    @Test
    @DisplayName("입력한 갯수만큼 랜덤한 숫자를 가진 로또들을 발행한다.")
    void GENERATE_LOTTOS_BY_INPUT_COUNT() {
        Assertions.assertThat(NumberGenerator.generateAutoNumbers(3).numberOfLotto())
            .isEqualTo(3);
    }

}
