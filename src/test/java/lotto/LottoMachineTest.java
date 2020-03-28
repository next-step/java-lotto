package lotto;

import lotto.domain.LottoGroup;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,14000,14", "2000,8000,4", "3000,4000,1"})
    @DisplayName("입력 값에 따라 구입한 로또 숫자들을 리턴한다.")
    public void createLottoNumsTest(int lottoPrice, int inputMoney, int lottoCount) {
        LottoMachine lottoMachine = new LottoMachine(lottoPrice);

        LottoGroup lottoGroup =  lottoMachine.generateLottoGroup(inputMoney);

        assertThat(lottoGroup.getNumbers()).hasSize(lottoCount);
        assertThat(lottoGroup.getLottoNumbersCount()).isEqualTo(lottoCount);
    }

}
