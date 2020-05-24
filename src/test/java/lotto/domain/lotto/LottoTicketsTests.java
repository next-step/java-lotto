package lotto.domain.lotto;

import lotto.domain.rank.RankCalculator;
import lotto.domain.rank.Ranks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTests {
    @DisplayName("로또 티켓 리스트를 입력받아서 일급 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<LottoTicket> lottoTicketList = Collections.singletonList(LottoGenerator.createByAuto());
        assertThat(LottoTickets.create(lottoTicketList)).isNotNull();
    }

    @DisplayName("사이드 이펙트가 없어야 한다.")
    @Test
    void checkSideEffect() {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(LottoGenerator.createByAuto());
        LottoTickets lottoTickets = LottoTickets.create(lottoTicketList);
        assertThat(lottoTickets.size()).isEqualTo(1);

        lottoTicketList.add(LottoGenerator.createByAuto());
        assertThat(lottoTickets.size()).isEqualTo(1);
    }

    @DisplayName("현재 상태를 기준으로 Rank들을 계산할 수 있어야 한다.")
    @Test
    void calculateRanks() {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(LottoGenerator.createByAuto());
        LottoTickets lottoTickets = LottoTickets.create(lottoTicketList);

        LottoTicket winTicket = LottoGenerator.createManualByIntList(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoTickets.calculateRanks(new RankCalculator(winTicket, LottoNumber.create(30))))
                .isInstanceOf(Ranks.class);
    }

    @DisplayName("LottoTickets끼리 합할 수 있다.")
    @Test
    void combineLottoTickets() {
        LottoTickets autoLottoTickets = LottoTickets.create(
                Arrays.asList(LottoGenerator.createByAuto(), LottoGenerator.createByAuto()));
        LottoTickets manualLottoTickets = LottoTickets.create(
                Collections.singletonList(LottoGenerator.createFromString("1,2,3,4,5,6")));

        LottoTickets combinedLottoTicket = autoLottoTickets.combine(manualLottoTickets);

        assertThat(combinedLottoTicket.size()).isEqualTo(3);
    }

    @DisplayName("빈 LottoTicket이 섞여 있어도 합할 수 있다.")
    @Test
    void combineEmpty() {
        LottoTickets emptyLottoTickets = LottoTickets.create(new ArrayList<>());
        LottoTickets autoLottoTickets = LottoTickets.create(
                Arrays.asList(LottoGenerator.createByAuto(), LottoGenerator.createByAuto()));

        assertThat(emptyLottoTickets.combine(autoLottoTickets).size()).isEqualTo(2);
        assertThat(autoLottoTickets.combine(emptyLottoTickets).size()).isEqualTo(2);
    }

    @DisplayName("현재 객체 내부에 수동 로또가 몇개인지, 자동 로또가 몇개인지 알 수 있다.")
    @Test
    void howManyAutoOrManualTest() {
        LottoTickets autoLottoTickets = LottoTickets.create(
                Arrays.asList(LottoGenerator.createByAuto(), LottoGenerator.createByAuto()));
        LottoTickets manualLottoTickets = LottoTickets.create(
                Collections.singletonList(LottoGenerator.createFromString("1,2,3,4,5,6")));

        LottoTickets combinedLottoTicket = autoLottoTickets.combine(manualLottoTickets);

        assertThat(combinedLottoTicket.countType(CreationType.AUTO)).isEqualTo(2);
        assertThat(combinedLottoTicket.countType(CreationType.MANUAL)).isEqualTo(1);
    }
}
