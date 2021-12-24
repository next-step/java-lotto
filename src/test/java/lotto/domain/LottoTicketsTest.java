package lotto.domain;

import lotto.domain.lottoGenerator.AutomaticLottoTicketsGenerator;
import lotto.domain.lottoGenerator.ManualLottoTicketsGenerator;
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
        ManualLottoTicketsGenerator manualLottoTicketsGenerator = new ManualLottoTicketsGenerator(manualLottoTickets);
        AutomaticLottoTicketsGenerator automaticLottoTicketsGenerator = new AutomaticLottoTicketsGenerator(3);

        //when
        LottoTickets lottoTickets = new LottoTickets(manualLottoTicketsGenerator.generate(), automaticLottoTicketsGenerator.generate());

        //then
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(5);
    }

    @DisplayName("로또 당첨정보를 알 수 있다.")
    @Test
    void winningStaticsMap() {
        //given
        List<String> manualLottoTickets = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 7");
        ManualLottoTicketsGenerator manualLottoTicketsGenerator = new ManualLottoTicketsGenerator(manualLottoTickets);
        LottoTickets lottoTickets = new LottoTickets(manualLottoTicketsGenerator.generate());
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from("1, 2, 3, 4, 5, 9", "6");

        //when
        WinningResult winInfo = lottoTickets.winningResult(lottoWinningNumbers, 2000);

        //then
        assertThat(winInfo.winningStatics()).hasEntrySatisfying(LottoRank.SECOND, value -> assertThat(value).isEqualTo(1));
        assertThat(winInfo.winningStatics()).hasEntrySatisfying(LottoRank.THIRD, value -> assertThat(value).isEqualTo(1));
    }


}