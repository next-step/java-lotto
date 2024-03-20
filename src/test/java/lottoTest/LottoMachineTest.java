package lottoTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import lotto.LottoGenerator;
import lotto.LottoMachine;
import lotto.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("구매한 로또 갯수만큼 로또를 생성합니다.")
    void CREATE_LOTTOS_BY_NUMBERS_OF_PURCHASED_LOTTO() {
        assertThat(LottoMachine.createLottos(5, new RandomLottoGenerator()).numberOfLotto())
            .isEqualTo(5);
    }

}
