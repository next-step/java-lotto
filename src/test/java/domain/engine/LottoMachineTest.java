package domain.engine;

import domain.model.Lotto;
import org.junit.jupiter.api.Test;
import domain.generator.StaticLottoNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void createTest() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoMachine lottoMachine = new LottoMachine(new StaticLottoNumberGenerator(lottoNumbers));
        List<Lotto> lottoList = lottoMachine.buyLottos(2000);
        assertThat(lottoList).hasSize(2);
        assertThat(lottoList.get(0).getLottoNumbers())
                .containsExactlyInAnyOrder(lottoNumbers.toArray(new Integer[0]));

    }
}
