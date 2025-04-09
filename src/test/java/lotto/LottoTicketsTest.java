package lotto;

import caculator.Operator;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.factory.LottoFactory;
import lotto.strategy.AutoLottoStrategy;
import lotto.strategy.LottoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LottoTicketsTest {

    public static final int COUNT = 14;
    LottoTickets lottoTickets;

    @BeforeEach
    public void setUpLottoTickets() {
        lottoTickets = LottoTickets.fromNumbers(COUNT,new AutoLottoStrategy());
    }

    @Test
    @DisplayName("입력한 count에 맞는 lottoTickets list를 반환한다.")
    void fromNumbers(){
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(COUNT);
    }

    @Test
    @DisplayName("두 LottoTickets 객체를 병합하면 모든 티켓이 포함된 새 객체를 반환한다")
    void merge() {
        LottoTicket manualTicket = LottoFactory.createLottoTicket("1,2,3,4,5,6");
        LottoTicket autoTicket = LottoFactory.createLottoTicket("7,8,9,10,11,12");
        LottoTickets manual = new LottoTickets(List.of(manualTicket));
        LottoTickets auto = new LottoTickets(List.of(autoTicket));

        LottoTickets merged = LottoTickets.merge(manual, auto);

        assertThat(merged.getLottoTickets())
                .hasSize(2)
                .containsExactly(manualTicket, autoTicket);
    }

    @Test
    @DisplayName("purchase()는 수동 구매 개수와 수동 구매 번호를 입력받아 나머지 자동 로또를 구매하여 총 로또 티켓을 반환한다.")
    void purchase_ValidInput() {
        int payment = 5000; // 총 금액
        int manualCount = 2; // 수동 티켓 개수
        LottoStrategy autoStrategy = new AutoLottoStrategy(); // 자동 생성 전략

        LottoTickets lottoTickets = LottoTickets.purchase(payment, manualCount, List.of("1,2,3,4,5,6", "7,8,9,10,11,12") ,autoStrategy);

        assertEquals(payment / LottoTickets.LOTTO_PRICE, lottoTickets.getLottoTickets().size()); // 총 티켓수 확인
    }

    @Test
    @DisplayName("purchase()는 가격보다 수동 구매 개수가 많으면 오류를 반환한다.")
    void purchase_ValidManualCount() {
        int payment = 1000; // 총 금액
        int manualCount = 2; // 수동 티켓 개수
        LottoStrategy autoStrategy = new AutoLottoStrategy(); // 자동 생성 전략

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoTickets.purchase(payment, manualCount, List.of("1,2,3,4,5,6", "7,8,9,10,11,12") ,autoStrategy);
        });

    }

    @Test
    @DisplayName("getLottoTickets()는 생성된 모든 티켓을 반환한다")
    void getLottoTickets_ReturnsAllTickets() {
        // Given
        List<LottoTicket> tickets = List.of(
                LottoFactory.createLottoTicket("1,2,3,4,5,6"),
                LottoFactory.createLottoTicket("7,8,9,10,11,12")
        );
        LottoTickets lottoTickets = new LottoTickets(tickets);

        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(tickets.size());
        assertThat(lottoTickets.getLottoTickets()).isEqualTo(tickets);
    }

    @Test
    @DisplayName("getCount()는 생성된 티켓의 개수를 반환한다")
    void getCount_ReturnsCorrectNumberOfTickets() {
        List<LottoTicket> tickets = List.of(
                LottoFactory.createLottoTicket("1,2,3,4,5,6"),
                LottoFactory.createLottoTicket("7,8,9,10,11,12")
        );
        LottoTickets lottoTickets = new LottoTickets(tickets);

        assertThat(lottoTickets.getCount()).isEqualTo(2);
    }
}
