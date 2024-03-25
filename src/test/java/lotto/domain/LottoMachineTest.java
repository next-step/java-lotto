package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("로또머신이 로또를 만들고 로또 각 사이즈는 6을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0:6", "1:6", "2:6", "3:6", "4:6", "5:6"}, delimiter = ':')
    void show_lotto_ticke_number(int index, int expected) {
        LottoMachine lottoMachine = new LottoMachine();
        List<LottoTicket> lottoTickets = lottoMachine.generateLottoTickets(14);
        assertThat(lottoTickets.get(index).generateLottoNumbers().size()).isEqualTo(expected);
    }

    @DisplayName("개수를 입력하면 로또번호 6개가 그 개수만큼 나온다")
    @Test
    void number_of_lotto() {
        LottoMachine lottoMachine = new LottoMachine();
        List<LottoTicket> lottoTickets = lottoMachine.generateLottoTickets(14);

        assertThat(lottoTickets.size()).isEqualTo(14);
    }

}
