package domain.engine;

import domain.model.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import domain.generator.StaticLottoNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("구입 금액에 따라 로또를 구매한다.")
    @Test
    void buyTest() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoMachine lottoMachine = new LottoMachine(new StaticLottoNumberGenerator(lottoNumbers));

        List<LottoNumbers> lottoList = lottoMachine.buyLottos(2000);
        assertThat(lottoList).hasSize(2);
        assertThat(lottoList.get(0).getNumbers())
                .containsExactlyInAnyOrder(lottoNumbers.toArray(new Integer[0]));

    }
}
