package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"14000,14", "8000,8", "4000,4"})
    @DisplayName("입력 값에 따라 구입한 로또 숫자들을 리턴한다.")
    public void createLottoNumsTest( int inputMoney, int lottoCount) {
        LottoTicket lottoTicket =  LottoMachine.generateLottoTicket(Money.won(inputMoney));

        assertThat(lottoTicket.getLotteryNumbers()).hasSize(lottoCount);
        assertThat(lottoTicket.size()).isEqualTo(lottoCount);
    }

}
