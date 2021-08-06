package lotto.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 기계 작동 테스트")
    void mixNumbers(){
        ArrayList<Integer> mixLottoNumbers = LottoMachine.mixLottoNumbers();
        assertThat(mixLottoNumbers.size()).isEqualTo(6);
    }
}
