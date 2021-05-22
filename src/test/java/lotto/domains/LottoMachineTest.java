package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void 생성자_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine).isNotNull();
    }

    @Test
    void 구입금액_만큼_로또반환_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.makeLottos(new Cash(14000));
        assertThat(lottos.count()).isEqualTo(14);
    }

    @Test
    void 스트링값을_숫자리스트로_변환_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        String data = "1, 2, 3, 4, 5, 6";
        List<Integer> expectedList = Arrays.asList(1,2,3,4,5,6);
        assertThat(lottoMachine.convertStringToList(data)).isEqualTo(expectedList);

    }
}
