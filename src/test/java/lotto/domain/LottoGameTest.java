package lotto.domain;

import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTicket;
import lotto.domain.numbers.LottoTickets;
import lotto.domain.numbers.WinningLottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    private WinningLottoTicket winningLottoTicket;
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        LottoTicket winningTicket = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 21, 40)));
        winningLottoTicket = new WinningLottoTicket(winningTicket, LottoNumber.of(30));

        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        manualLottoTickets.add(new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 21, 40))));  //1등
        manualLottoTickets.add(new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 21, 30))));  //2등
        manualLottoTickets.add(new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 21, 29))));  //3등

        List<LottoTicket> autoLottoTickets = new ArrayList<>();
        autoLottoTickets.add(new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 14, 20, 39))));    //4등
        autoLottoTickets.add(new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 8, 10, 15, 20, 40))));    //4등

        lottoGame = new LottoGame(new LottoTickets(manualLottoTickets), new LottoTickets(autoLottoTickets));
    }

    @DisplayName("발급한 로또 티켓들과 당첨 번호를 비교하여 각 맞춘 갯수들을 저장하여 리턴한다.")
    @Test
    void matchNumbers() {
        Map<Rank, Integer> results = lottoGame.matchNumbers(winningLottoTicket).getResult();

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(2);
        assertThat(results.get(Rank.FIFTH)).isZero();
    }
}
