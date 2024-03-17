package lotto.domain;

import lotto.numberdrawer.ShuffledNumberDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 개수와 NumberDrawer를 매개변수로 받아 LottoNumbers를 반환")
    void createLottoNumbers() {
        LottoNumbers lottoNumbers = LottoMachine.createLottoNumbers(14, new ShuffledNumberDrawer());
        assertThat(lottoNumbers.size()).isEqualTo(14);
    }
}
