package lotto.domain;

import lotto.numberdrawer.ShuffledNumberDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("로또 개수와 NumberDrawer를 매개변수로 받아 LottoNumbers를 반환")
    void createLottoNumbers(int countOfLotto) {
        LottoNumbers lottoNumbers = LottoMachine.createLottoNumbers(countOfLotto, new ShuffledNumberDrawer());
        assertThat(lottoNumbers.size()).isEqualTo(countOfLotto);
    }
}
