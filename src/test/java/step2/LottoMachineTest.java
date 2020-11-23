package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoMachineTest {

    @Test
    @DisplayName("getLotto는 1~45 사이즈 숫자리스트를 중복없이 정렬해서 리턴함.")
    void getLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        for (int i=0; i<10; i++){
            System.out.println(lottoMachine.getLotto());
        }
        assertThat(lottoMachine.getLotto().length).isEqualTo(6);
        assertThat((int)lottoMachine.getLotto()[5]).isLessThan(46);
        assertThat((int)lottoMachine.getLotto()[0]).isGreaterThan(0);
        assertThat(Arrays.stream(lottoMachine.getLotto()).distinct().count()).isEqualTo(6L);
    }

    @Test
    @DisplayName("요청한 수만큼 로또를 만들어서 로또 리스트를 리턴함.")
    void buy() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.buy(10).size()).isEqualTo(10);
    }
}