package lotto.application;

import lotto.domain.lotto.*;
import lotto.domain.rank.Ranks;
import lotto.domain.shop.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTests {
    private LottoService lottoService;

    @BeforeEach
    public void setup() {
        lottoService = new LottoService();
    }

    @DisplayName("돈을 입력받아서 자동으로 로또를 구매한 뒤 LottoTickets를 반환")
    @Test
    void buyLottoTest() {
        LottoTickets lottoTickets = lottoService.buyLottoTicketsAllAuto(new Money(10000));
        assertThat(lottoTickets.size()).isEqualTo(10);
    }

    @DisplayName("당첨 티켓 번호와 구매한 LottoTickets를 받아서 당첨 결과를 반환할 수 있다.")
    @Test
    void rankCalculateTest() {
        LottoTicket winTicket = LottoGenerator.createByManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber winBonusNumber = LottoNumber.create(10);
        LottoTickets lottoTickets = LottoTickets.create(
                Arrays.asList(LottoGenerator.createByAuto(), LottoGenerator.createByAuto()));

        assertThat(lottoService.calculateRank(winTicket, winBonusNumber, lottoTickets)).isInstanceOf(Ranks.class);
    }

    @DisplayName("수동 구매 LottoTickets와 구매 총 금액을 전달해서 LottoTickets를 받을 수 있다.")
    @Test
    void buyCombineTest() {
        LottoTickets manualLottoTickets = LottoTickets.create(Arrays.asList(
                LottoGenerator.createByManual("1,2,3,4,5,6"),
                LottoGenerator.createByManual("2,3,4,5,6,7"))
        );

        LottoTickets lottoTickets = lottoService.buyLottoTicketsCombine(manualLottoTickets, new Money(4000));

        assertThat(lottoTickets.size()).isEqualTo(4);
    }
}
