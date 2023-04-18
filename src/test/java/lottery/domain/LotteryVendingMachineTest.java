package lottery.domain;

import lottery.domain.issue.ManualTicketIssueStrategy;
import lottery.domain.issue.RandomTicketIssueStrategy;
import lottery.domain.issue.TicketIssueStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lottery.domain.LotteryNumber.getAllLotteryNumbers;
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
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine(manualTicketIssueStrategy);

        // then
        assertThat(lotteryVendingMachine).isNotNull();
    }

    @Test
    @DisplayName("밴딩 머신에서 자동 로또번호 티켓 발급 생성 확인")
    void issueRandom() {
        // given
        TicketIssueStrategy ticketIssueStrategy = new RandomTicketIssueStrategy(getAllLotteryNumbers());
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine(ticketIssueStrategy);

        // when
        LotteryTicket lotteryTicket = lotteryVendingMachine.issueTicket();

        // then
        assertThat(lotteryTicket).isNotNull();
        assertThat(lotteryTicket.numberCount()).isEqualTo(LotteryTicket.LOTTERY_TICKET_SIZE);
    }

    @Test
    @DisplayName("밴딩 머신에서 수동 로또번호 티켓 발급 번호 확인")
    void issueManual() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine(manualTicketIssueStrategy);

        // when
        LotteryTicket lotteryTicket = lotteryVendingMachine.issueTicket();

        // then
        assertThat(lotteryTicket).isNotNull();
        assertThat(lotteryTicket.numberCount()).isEqualTo(LotteryTicket.LOTTERY_TICKET_SIZE);
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(manualNumbers));
    }

    @Test
    @DisplayName("로또머신에 금액 투입")
    void insertMoney() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine(manualTicketIssueStrategy);
        int money = 5000;

        // when
        lotteryVendingMachine.insertMoney(money);

        // then
        assertThat(lotteryVendingMachine.getBalance()).isEqualTo(money);
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아닌 경우 예외")
    void invalidMoney() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine(manualTicketIssueStrategy);
        int money = 500;

        // then
        assertThatThrownBy(() -> lotteryVendingMachine.insertMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 1000원 단위로 입력해주세요.");
    }

    @Test
    @DisplayName("로또머신에서 티켓 판매 확인")
    void sellTickets() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine(manualTicketIssueStrategy);
        int money = 1000;
        lotteryVendingMachine.insertMoney(money);

        // when
        LotteryTicket lotteryTicket = lotteryVendingMachine.sellTicket();

        // then
        assertThat(lotteryVendingMachine.getBalance()).isEqualTo(0);
        assertThat(lotteryTicket).isNotNull();
        assertThat(lotteryTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("로또머신에서 티켓 판매 예외")
    void sellException() {
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine(manualTicketIssueStrategy);
        int money = 1000;
        lotteryVendingMachine.insertMoney(money);

        // when
        lotteryVendingMachine.sellTicket();
        assertThatThrownBy(lotteryVendingMachine::sellTicket)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("잔액이 부족합니다.");
    }

    @Test
    @DisplayName("로또머신에 넣은 금액만큼 판매")
    void insertAndSell() {
        // given
        LotteryVendingMachine lotteryVendingMachine = new LotteryVendingMachine(manualTicketIssueStrategy);
        int money = 5000;
        lotteryVendingMachine.insertMoney(money);

        // when
        List<LotteryTicket> lotteryTickets = lotteryVendingMachine.sellAvailableTickets();

        // then
        assertThat(lotteryVendingMachine.getBalance()).isEqualTo(0);
        assertThat(lotteryTickets.size()).isEqualTo(money / 1000);
        assertThat(lotteryVendingMachine.soldCount()).isEqualTo(money / 1000);
    }
}