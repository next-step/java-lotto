package lotto.domain;

import lotto.domain.strategy.AutomaticLottoTicketsGenerator;
import lotto.domain.strategy.ManualLottoTicketsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("로또 생성기를 통해서 로또 티켓을 생성한다.")
    @Test
    void generate() {
        //given
        List<String> manualLottoTickets = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 7");
        ManualLottoTicketsGenerator manualLottoTicketsGenerator = new ManualLottoTicketsGenerator(manualLottoTickets, 1000);
        AutomaticLottoTicketsGenerator automaticLottoTicketsGenerator = new AutomaticLottoTicketsGenerator(3, 1000);

        //when
        LottoTickets lottoTickets = new LottoTickets(manualLottoTicketsGenerator, automaticLottoTicketsGenerator);

        //then
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(5);
    }

    @DisplayName("로또 당첨정보를 알 수 있다.")
    @Test
    void winningStaticsMap() {
        //given
        List<String> manualLottoTickets = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 7");
        ManualLottoTicketsGenerator manualLottoTicketsGenerator = new ManualLottoTicketsGenerator(manualLottoTickets, 1000);
        LottoTickets lottoTickets = new LottoTickets(manualLottoTicketsGenerator);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from("1, 2, 3, 4, 5, 9", "6");


        //when
        LottoTicketsWinInformation winInfo = lottoTickets.winInformation(lottoWinningNumbers);

        //then
        assertThat(winInfo.winningStatics()).hasEntrySatisfying(LottoRank.SECOND, value -> assertThat(value).isEqualTo(1));
        assertThat(winInfo.winningStatics()).hasEntrySatisfying(LottoRank.THIRD, value -> assertThat(value).isEqualTo(1));
    }


}