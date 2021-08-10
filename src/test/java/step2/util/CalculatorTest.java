package step2.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoMachine;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @DisplayName("로또 결과 저장이 잘 되고 있는지 확인")
    @Test
    void test() {

        LottoMachine lottoMachine = new LottoMachine();

        ArrayList<ArrayList> issuedLottolist = new ArrayList<>();
        issuedLottolist.add(new ArrayList(Arrays.asList(1,2,3,4,5,6)));
        issuedLottolist.add(new ArrayList(Arrays.asList(1,2,3,4,5)));
        Calculator calculator = new Calculator(issuedLottolist, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        calculator.run();
        int[] lottoResultArray = calculator.getLottoResultArray();

        Assertions.assertThat(lottoResultArray[6]).isEqualTo(1);
        Assertions.assertThat(lottoResultArray[5]).isEqualTo(1);
        Assertions.assertThat(lottoResultArray[4]).isEqualTo(0);
        Assertions.assertThat(lottoResultArray[3]).isEqualTo(0);
        Assertions.assertThat(lottoResultArray[2]).isEqualTo(0);
        Assertions.assertThat(lottoResultArray[1]).isEqualTo(0);

    }

}