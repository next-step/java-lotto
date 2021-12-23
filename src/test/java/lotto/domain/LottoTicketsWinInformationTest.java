package lotto.domain;

import lotto.domain.strategy.ManualLottoTicketsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsWinInformationTest {

    @DisplayName("로또 당첨 번호를 전달하면 일치하는 개수가 몇 개 있는지 알 수 있다.")
    @Test
    void winningStatics() {
        //given
        List<String> manualLottoTickets = Arrays.asList("1, 2, 3, 4, 5, 9", "1, 2, 3, 4, 5, 7");
        ManualLottoTicketsGenerator manualLottoTicketsGenerator = new ManualLottoTicketsGenerator(manualLottoTickets);
        LottoTickets lottoTickets = new LottoTickets(manualLottoTicketsGenerator.generate());
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from("1, 2, 3, 4, 5, 9", "6");
        LottoTicketsWinInformation winInfo = lottoTickets.winInformation(lottoWinningNumbers, 2000);


        //when
        Map<LottoRank, Integer> map = winInfo.winningStatics();

        //then
        assertThat(map.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(map.get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(map.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(map.get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(map.get(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(map.get(LottoRank.MISS)).isEqualTo(0);

    }

    @DisplayName("LottoTickets 당첨금을 계산한다.")
    @Test
    void winningPrize() {
        //given
        List<String> manualLottoTickets = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 24, 25, 27");
        ManualLottoTicketsGenerator manualLottoTicketsGenerator = new ManualLottoTicketsGenerator(manualLottoTickets);
        LottoTickets lottoTickets = new LottoTickets(manualLottoTicketsGenerator.generate());
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from("1, 2, 3, 4, 5, 9", "6");
        LottoTicketsWinInformation winInfo = lottoTickets.winInformation(lottoWinningNumbers, 2000);

        //when
        int winningPrize = winInfo.winningPrize();

        //then
        assertThat(winningPrize).isEqualTo(30_005_000);

    }


    @DisplayName("LottoTickets 수익률 계산한다.")
    @Test
    void earningRate() {

        //given
        List<String> manualLottoTickets = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 22");
        ManualLottoTicketsGenerator manualLottoTicketsGenerator = new ManualLottoTicketsGenerator(manualLottoTickets);
        LottoTickets lottoTickets = new LottoTickets(manualLottoTicketsGenerator.generate());
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from("1, 2, 3, 4, 5, 6", "45");
        LottoTicketsWinInformation winInfo = lottoTickets.winInformation(lottoWinningNumbers, 2000);

        //when
        double earningRate = winInfo.earningRate();

        //then
        assertThat(earningRate).isEqualTo(1000750.0);
    }

}