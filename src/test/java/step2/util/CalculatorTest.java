package step2.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domain.LottoMachine;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test() {

        LottoMachine lottoMachine = new LottoMachine(6, "1, 2, 3, 4, 5, 6");

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