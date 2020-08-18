package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoMachineTest {

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void shuffle_Lotto_Numbers_test() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> pickedNumbers = lottoMachine.generateLottoNumber();
        assertEquals(5, pickedNumbers.size());
    }

}
