package lottery.domain;

import lottery.strategy.ManualTicketIssueStrategy;
import lottery.strategy.RandomTicketIssueStrategy;
import lottery.strategy.TicketIssueStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryVendingMachineTest {
    private List<LotteryNumber> manualNumbers;
    private TicketIssueStrategy manualTicketIssueStrategy;

    @BeforeEach
    void setUp() {
        List<Integer> manualInts = Arrays.asList(1, 2, 3, 4, 5, 6);
        manualNumbers = manualInts.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        manualTicketIssueStrategy = new ManualTicketIssueStrategy(manualInts);
    }

    @Test
    @DisplayName("로또머신 생성")
    void create() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine();

        // then
        assertThat(lotteryVendingMachine).isNotNull();
    }

    @Test
    @DisplayName("밴딩 머신에서 자동 로또번호 티켓 발급 생성 확인")
    void issueRandom() {
        // given
        TicketIssueStrategy ticketIssueStrategy = new RandomTicketIssueStrategy();
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine();

        // when
        LotteryTicket lotteryTicket = lotteryVendingMachine.issueTicket(ticketIssueStrategy);

        // then
        assertThat(lotteryTicket).isNotNull();
        assertThat(lotteryTicket.numberCount()).isEqualTo(LotteryTicket.LOTTERY_TICKET_SIZE);
    }

    @Test
    @DisplayName("밴딩 머신에서 수동 로또번호 티켓 발급 번호 확인")
    void issueManual() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine();

        // when
        LotteryTicket lotteryTicket = lotteryVendingMachine.issueTicket(manualTicketIssueStrategy);

        // then
        assertThat(lotteryTicket).isNotNull();
        assertThat(lotteryTicket.numberCount()).isEqualTo(LotteryTicket.LOTTERY_TICKET_SIZE);
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(manualNumbers));
    }

    @Test
    @DisplayName("로또머신에 금액 투입")
    void insertMoney() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine();
        int money = 5000;

        // when
        int ticketCount = lotteryVendingMachine.calculateNumberOfTickets(money);

        // then
        assertThat(ticketCount).isEqualTo(money / 1000);
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아닌 경우 예외")
    void invalidMoney() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine();
        int money = 500;

        // then
        assertThatThrownBy(() -> lotteryVendingMachine.calculateNumberOfTickets(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 1000원 단위로 입력해주세요.");
    }

    @Test
    @DisplayName("로또머신에서 티켓 판매 확인")
    void sellTickets() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine();
        int money = 1000;

        // when
        List<LotteryTicket> lotteryTickets = lotteryVendingMachine.sellTickets(money, manualTicketIssueStrategy);

        // then
        assertThat(lotteryTickets.size()).isEqualTo(1);
        assertThat(lotteryTickets.get(0).toString()).isEqualTo("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("로또머신에 넣은 금액만큼 판매")
    void insertAndSell() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine();
        int money = 5000;

        // when
        List<LotteryTicket> lotteryTickets = lotteryVendingMachine.sellTickets(money, manualTicketIssueStrategy);

        // then
        assertThat(lotteryTickets.size()).isEqualTo(money / 1000);
    }
}